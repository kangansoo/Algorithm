import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, M, K;
    static int[] dist, friends;
    static List<List<Node>> graph;
    static class Node implements Comparable<Node>{
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
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

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
                graph.get(b).add(new Node(a, c));
            }

            K = Integer.parseInt(br.readLine());
            friends = new int[K];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<K; i++){
                int a = Integer.parseInt(st.nextToken());
                friends[i]=a;
            }

            dist = new int[K*N+1];
            Arrays.fill(dist, INF);

            for(int i=0;i<K;i++){
                dijkstra(friends[i], i);
            }

            int minValue = INF;
            int answer = 0;
            for(int i=1; i<=N; i++){
                int tmp=0;
                for(int j=0; j<K; j++){
                    tmp+=dist[i+j*N];
                }
                if(tmp<minValue){
                    minValue = tmp;
                    answer = i;
                }
            }

            System.out.println(answer);
        }
    }

    static void dijkstra(int start, int idx){
        int tmp = idx*N;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start+tmp]=0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int currV = curr.to;
            int currC = curr.cost;

            if(currC>dist[currV+tmp]) continue;

            for(Node next:graph.get(currV)){
                int newDist = currC+next.cost;
                if(newDist<dist[next.to+tmp]){
                    dist[next.to+tmp]=newDist;
                    pq.add(new Node(next.to, newDist));
                }
            }
        }
    }
}
