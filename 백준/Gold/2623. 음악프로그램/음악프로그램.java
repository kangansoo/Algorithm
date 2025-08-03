import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] order;
    static List<List<Integer>> graph;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        order = new int[N+1];
        graph = new ArrayList<>();

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int prev=0;
            for(int j=0; j<n; j++) {
                int curr = Integer.parseInt(st.nextToken());

                if(prev==0) {
                    prev=curr;
                } else {
                    graph.get(prev).add(curr);
                    order[curr]++;
                    prev=curr;
                }
            }
        }

        topology();
    }

    static void topology() {
        Queue<Integer> q = new LinkedList<>();
        int cnt=0;
        for(int i=1; i<=N; i++) {
            if(order[i]==0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            sb.append(curr).append("\n");
            cnt++;

            for(int next:graph.get(curr)) {
                order[next]--;
                if(order[next]==0) {
                    q.add(next);
                }
            }
        }

        if(cnt!=N) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
    }
}
