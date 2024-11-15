import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static final int INF = Integer.MAX_VALUE;
    static List<List<Edge>> graph;
    static int[] dist;
    static class Edge implements  Comparable<Edge>{
        int to, cost;
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        dist = new int[N];

        for(int i=0; i<N; i++){
            graph.add(new ArrayList<>());
        }
        Arrays.fill(dist, INF);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
//            if(a>b){
//                graph.get(b).add(new Edge(a, c));
//            } else {
//                graph.get(a).add(new Edge(b, c));
//            }
        }

        dijkstra(0);

        System.out.println(dist[N-1]);
    }

    static void dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start]=0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            int currV = curr.to;
            int currC = curr.cost;

            if(currC>dist[currV]) continue;

            for(Edge next:graph.get(currV)){
                int newDist = next.cost+currC;
                if(newDist<dist[next.to]){
                    dist[next.to]=newDist;
                    pq.add(new Edge(next.to, newDist));
                }
            }
        }
    }
}