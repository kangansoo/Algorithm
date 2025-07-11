import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, M, X;
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
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        int[] result = new int[N+1];
        int answer=0;
        for(int i=1; i<=N; i++){
            if(i==X) continue;
            result[i] = dijkstra(i, X);
        }
        for(int i=1; i<=N; i++){
            if(i==X) continue;
            result[i] += dijkstra(X, i);
            answer = Math.max(answer, result[i]);
        }

        System.out.println(answer);
    }

    static int dijkstra(int start, int end){
        dist = new int[N+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

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
