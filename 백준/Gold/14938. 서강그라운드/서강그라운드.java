import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, M, R;
    static int[] dist, items;
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
            return this.cost-o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        items = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        int answer=0;

        for(int i=1; i<=N; i++){
            int sum=0;
            dijkstra(i);
            for(int j=1; j<=N; j++){
                if(dist[j]<=M){
                    sum+=items[j];
                }
            }
            answer=Math.max(answer,sum);
        }

        System.out.println(answer);
    }

    static void dijkstra(int start){
        dist = new int[N+1];
        for(int i=0; i<=N; i++){
            dist[i]=INF;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start]=0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int currV = curr.to;
            int currC = curr.cost;

            if(currC>dist[currV]) continue;

            for(Node next:graph.get(currV)){
                int newDist = next.cost+currC;
                if(newDist<dist[next.to]){
                    dist[next.to]=newDist ;
                    pq.add(new Node(next.to, newDist));
                }
            }
        }
    }
}
