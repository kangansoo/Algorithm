import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE;;
    static int V, E;
    static long[] dist;
    static int[] wards;
    static List<List<Edge>> graph;

    static class Edge {
        int to;
        long cost;

        public Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new long[V];
        wards = new int[V];
        graph = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<V; i++){
            wards[i]=Integer.parseInt(st.nextToken());
            graph.add(new ArrayList<>());
        }

        Arrays.fill(dist, INF);

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, cost));
            graph.get(to).add(new Edge(from, cost));
        }

        dijkstra();

        long answer = dist[V-1]==INF?-1:dist[V-1];

        System.out.println(answer);
    }

    static void dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b)->Long.compare(a.cost, b.cost));
        pq.add(new Edge(0, 0));

        dist[0]=0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            int currV = curr.to;
            long currC = curr.cost;

            if(currC>dist[currV]) continue;

            for(Edge next:graph.get(currV)){
                if(next.to!=V-1 && wards[next.to]==1) continue;
                long newDist = currC+next.cost;
                if(newDist<dist[next.to]){
                    dist[next.to]=newDist;
                    pq.add(new Edge(next.to, newDist));
                }
            }
        }
    }
}