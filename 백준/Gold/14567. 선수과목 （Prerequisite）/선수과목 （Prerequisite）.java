import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] classes, semester;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        classes = new int[N+1];
        semester = new int[N+1];
        graph = new ArrayList<>();

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            classes[b]++;
        }

        topology();

        for(int i=1; i<=N; i++){
            sb.append(semester[i]).append(" ");
        }

        System.out.println(sb);
    }

    static void topology(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(classes[i]==0){
                q.add(i);
                semester[i]=1;
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next:graph.get(curr)){
                classes[next]--;
                if(classes[next]==0){
                    q.add(next);
                    semester[next]=semester[curr]+1;
                }
            }
        }
    }
}