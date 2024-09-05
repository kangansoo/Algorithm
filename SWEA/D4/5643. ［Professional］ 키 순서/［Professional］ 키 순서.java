import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int V, E, answer;
    static boolean[] visited;
    static List<Integer>[] adjList1, adjList2;
    static int[] cntArray;

    public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++) {
        	
        	V = Integer.parseInt(br.readLine());
            E = Integer.parseInt(br.readLine());
            
            adjList1 = new ArrayList[V + 1];
            adjList2 = new ArrayList[V + 1];
            cntArray = new int[V + 1];
            
            for (int i = 1; i <= V; i++) {
                adjList1[i] = new ArrayList<>();
                adjList2[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                
                adjList1[u].add(v); 
                adjList2[v].add(u); 
            }

            for (int i = 1; i <= V; i++) {
                visited = new boolean[V + 1];
                dfs(i, adjList1); 
                visited = new boolean[V + 1];
                dfs(i, adjList2);
            }
            
            answer = 0;
            for (int i = 1; i <= V; i++) {
                if (cntArray[i] == V - 1) {
                    answer++;
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, List<Integer>[] adjList) {
        visited[x] = true;
        for (int nx : adjList[x]) {
            if (!visited[nx]) {
                cntArray[nx]++;
                dfs(nx, adjList);
            }
        }
    }
}