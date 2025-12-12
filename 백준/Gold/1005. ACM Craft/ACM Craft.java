

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K, answer, target;
    static List<List<Integer>> graph;
    static int[] degree, time;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb= new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T --> 0) {
            answer = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for(int i=0; i<=N; i++) {
                graph.add(new ArrayList<>());
            }
            degree = new int[N+1];
            time = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                degree[b]++;
            }

            target = Integer.parseInt(br.readLine());

            simul();
        }

        System.out.println(sb);
    }

    static void simul() {
        Queue<Integer> q = new LinkedList<>();
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++) {
            if(degree[i]==0) {
                q.add(i);
                dp[i] = time[i];
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            if(curr==target) {
                sb.append(dp[curr]).append("\n");
                return;
            }

            for(int next:graph.get(curr)) {
                degree[next]--;
                dp[next] = Math.max(dp[next], dp[curr]+time[next]);

                if(degree[next]==0) {
                    q.add(next);
                }
            }
        }
    }
}
