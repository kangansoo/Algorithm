

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Node>> adj = new ArrayList<>();
    static int[] dist, parent;
    static int N, M;
    static class Node implements Comparable<Node> {
        int to, cost;
        public Node(int to, int cost) {
            this.to=to;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N+1];
        parent = new int[N+1];
        for(int i=0; i<=N; i++) {
            dist[i]=Integer.MAX_VALUE;
        }

        for(int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj.get(a).add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        int tmp=end;
        List<Integer> path = new ArrayList<>();

        while(tmp!=0) {
            path.add(tmp);
            tmp=parent[tmp];
        }

        Collections.reverse(path);

        System.out.println(dist[end]);
        System.out.println(path.size());
        for(int p:path) {
            System.out.print(p+" ");
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start]=0;

        while(!pq.isEmpty()) {
            Node curr = pq.poll();

            if(curr.cost>dist[curr.to]) continue;

            for(Node next:adj.get(curr.to)) {
                int newCost = dist[curr.to]+next.cost;
                if(newCost<dist[next.to]) {
                    dist[next.to]=newCost;
                    parent[next.to]=curr.to;
                    pq.add(new Node(next.to, newCost));
                }
            }
        }
    }
}
