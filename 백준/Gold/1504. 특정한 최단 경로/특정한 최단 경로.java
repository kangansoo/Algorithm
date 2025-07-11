import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = 200000*1000;
    static int N, E;
    static int[] dist;
    static List<List<Node>> graph;
    static class Node implements Comparable<Node> {
        int to;
        int cost;
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int answer1 = 0;
        answer1+=dijkstra(1, v1);
        answer1+=dijkstra(v1, v2);
        answer1+=dijkstra(v2, N);

        int answer2 = 0;
        answer2+=dijkstra(1, v2);
        answer2+=dijkstra(v2, v1);
        answer2+=dijkstra(v1, N);

        if(answer1>=INF && answer2>=INF){
            System.out.println(-1);
        } else {
            System.out.println(Math.min(answer1, answer2));
        }
    }

    static int dijkstra(int start, int end){
        dist = new int[N+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start]=0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int currV = curr.to;
            int currC = curr.cost;

            if(currC>dist[currV]) continue;

            for(Node next:graph.get(currV)){
                int newDist = currC+next.cost;
                if(newDist<dist[next.to]){
                    dist[next.to]=newDist;
                    pq.add(new Node(next.to, newDist));
                }
            }
        }

        return dist[end];
    }
}
