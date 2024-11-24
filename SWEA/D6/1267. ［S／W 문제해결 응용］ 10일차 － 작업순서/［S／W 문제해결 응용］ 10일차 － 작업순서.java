import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int V, E;
    static int[] isDegree;
    static List<List<Integer>> graph;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        int T=10;
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t=1; t<=T; t++){
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            isDegree = new int[V+1];
            graph = new ArrayList<>();

            for(int i=0; i<=V; i++){
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<E; i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                isDegree[b]++;
            }

            topology();

            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void topology(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=V; i++){
            if(isDegree[i]==0){
                q.add(i);
                sb.append(i).append(" ");
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next:graph.get(curr)){
                isDegree[next]--;
                if(isDegree[next]==0){
                    q.add(next);
                    sb.append(next).append(" ");
                }
            }
        }
    }
}