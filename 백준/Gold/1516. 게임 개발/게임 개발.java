import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] time, order, answer;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        time = new int[N+1];
        order = new int[N+1];
        answer = new int[N+1];

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            time[i]=a;

            while(true) {
                int b = Integer.parseInt(st.nextToken());
                if(b==-1) break;
                graph.get(b).add(i);
                order[i]++;
            }
        }
        
        topology();

        for(int i=1; i<=N; i++){
            System.out.println(answer[i]);
        }
    }

    static void topology() {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(order[i]==0) {
                q.add(i);
                answer[i]=time[i];
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int next:graph.get(curr)) {
                order[next]--;
                answer[next] = Math.max(answer[next], answer[curr]+time[next]);
                if(order[next]==0) {
                    q.add(next);
                }
            }
        }
    }
}
