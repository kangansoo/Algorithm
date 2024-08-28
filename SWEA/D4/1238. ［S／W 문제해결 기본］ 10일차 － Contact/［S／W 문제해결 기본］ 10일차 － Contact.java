import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int[][] adjMatrix;
    static int maxNode;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= 10; t++) {
            sb.append("#").append(t).append(" ");
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());  // 전체 입력 데이터의 수
            int start = Integer.parseInt(st.nextToken()); // 시작점
            
            maxNode = 0;
            int[] edges = new int[V];
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < V; i++) {
                edges[i] = Integer.parseInt(st.nextToken());
                if (edges[i] > maxNode) {
                    maxNode = edges[i];
                }
            }
            
            adjMatrix = new int[maxNode + 1][maxNode + 1]; // 가장 큰 정점 번호에 맞춰서 크기 설정
            
            for (int i = 0; i < V / 2; i++) {
                int from = edges[2 * i];
                int to = edges[2 * i + 1];
                adjMatrix[from][to] = 1; // 유향 그래프
            }

            sb.append(bfs(start)).append("\n");
        }
        
        System.out.println(sb);
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[maxNode + 1];
        
        visited[start] = true;
        queue.offer(start);
		int lastBreadth=Integer.MIN_VALUE;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            lastBreadth=Integer.MIN_VALUE;
            
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                lastBreadth = Math.max(cur,  lastBreadth);
                
                for (int next = 0; next <= maxNode; next++) {
                    if (adjMatrix[cur][next] == 0 || visited[next]) continue;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        
        return lastBreadth;
    }
}