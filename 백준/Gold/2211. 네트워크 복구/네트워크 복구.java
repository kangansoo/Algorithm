

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static List<List<Node>> adj;
    static int[] dist, parents;
    static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj.get(a).add(new Node(b, c));
            adj.get(b).add(new Node(a, c));
        }

        dist = new int[N+1];
        parents = new int[N+1];

        Arrays.fill(dist, INF);

        dijkstra(1);

        List<int[]> res = new ArrayList<>();
        for(int i=2; i<=N; i++) {
            res.add(new int[] {i, parents[i]});
        }

        System.out.println(res.size());
        for(int[] r:res) {
            System.out.println(r[0]+" "+r[1]);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start]=0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            if(curr.cost>dist[curr.to]) continue;

            for(Node next:adj.get(curr.to)) {
                int newCost = dist[curr.to]+next.cost;
                if(newCost<dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                    parents[next.to]=curr.to;
                }
            }
        }
    }
}
