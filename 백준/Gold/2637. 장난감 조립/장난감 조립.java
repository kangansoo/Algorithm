

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> adj;
    static int[] indegree, answer;
    static boolean[] isComb;
    static int[][] table;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        isComb = new boolean[N+1];
        table = new int[N+1][N+1];
        indegree = new int[N+1];
        answer = new int[N+1];
        for(int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            isComb[a]=true;

            adj.get(a).add(b);
            table[a][b]=c;
            indegree[b]++;
        }

        topology();

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++) {
            if(!isComb[i]) sb.append(i).append(" ").append(answer[i]).append("\n");
        }

        System.out.println(sb);

    }

    static void topology() {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(indegree[i]==0) {
                q.add(i);
                answer[i]=1;
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int next:adj.get(curr)) {
                answer[next] += table[curr][next]*answer[curr];
                indegree[next]--;
                if(indegree[next]==0) q.add(next);
            }
        }
    }
}
