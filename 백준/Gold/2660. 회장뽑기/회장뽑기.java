import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, minValue=Integer.MAX_VALUE;
    static List<List<Integer>> graph;
    static int[] scores;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a;
        int b;
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        while(true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(a==-1 && b==-1){
                break;
            }
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        scores = new int[N+1];

        for(int i=1; i<=N; i++){
            scores[i]=bfs(i);
            minValue=Math.min(scores[i], minValue);
        }

        int cnt=0;
        for(int i=1; i<=N; i++){
            if(scores[i]==minValue){
                cnt++;
            }
        }
        System.out.println(minValue+" "+cnt);
        for(int i=1; i<=N; i++){
            if(scores[i]==minValue){
                System.out.print(i+" ");
            }
        }

    }

    static int bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});

        visited = new boolean[N+1];
        visited[start]=true;

        int maxDistance=0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int now = curr[0];
            int distance = curr[1];
            maxDistance = Math.max(distance, maxDistance);

            for(int next:graph.get(now)){
                if(!visited[next]) {
                    visited[next]=true;
                    q.offer(new int[]{next, distance+1});
                }
            }
        }

        return maxDistance;
    }
}