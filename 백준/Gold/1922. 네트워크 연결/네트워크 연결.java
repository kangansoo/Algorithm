import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int V, E;
    static class Edge implements Comparable<Edge>{
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost-o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine().trim());
        E = Integer.parseInt(br.readLine().trim());
        make();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Edge(from, to, cost));
        }

        int result=0;
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            if(union(curr.from, curr.to)){
                result+=curr.cost;
            }

        }
        System.out.println(result);

    }

    static void make(){
        parents = new int[V+1];
        for(int i=1; i<=V; i++){
            parents[i]=i;
        }
    }

    static int find(int a){
        if(parents[a]==a) return a;
        return parents[a]=find(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot==bRoot) return false;

        parents[aRoot]=bRoot;
        return true;
    }
}