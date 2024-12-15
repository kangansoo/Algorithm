import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static StringBuilder sb;
    static int[] isDegree, numbers;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        isDegree = new int[N+1];
        numbers = new int[N+1];

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1; i<=N; i++){
            numbers[i]=i;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            isDegree[b]++;
        }

        topology();

        System.out.println(sb);
    }

    static void topology() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (isDegree[i] == 0) {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            sb.append(curr).append(" ");
            for (int next : graph.get(curr)) {
                isDegree[next]--;
                if (isDegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }
    }

}