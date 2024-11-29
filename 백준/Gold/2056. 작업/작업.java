import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, answer;
    static int[] works, isDegree, time;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());

        answer=0;
        works = new int[N+1];
        isDegree = new int[N+1];
        time = new int[N+1];
        graph = new ArrayList<>();

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            works[i]=a;
            int b = Integer.parseInt(st.nextToken());
            isDegree[i]=b;
            for(int j=0; j<b; j++){
                int c = Integer.parseInt(st.nextToken());
                graph.get(c).add(i);
            }
        }

        topology();

        for(int t:time){
            answer=Math.max(answer, t);
        }

        System.out.println(answer);
    }

    static void topology(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(isDegree[i]==0) {
                q.add(i);
                time[i]=works[i];
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next:graph.get(curr)){
                isDegree[next]--;
                time[next] = Math.max(time[next], time[curr]+works[next]);
                if(isDegree[next]==0){
                    q.add(next);
                }
            }
        }
    }
}