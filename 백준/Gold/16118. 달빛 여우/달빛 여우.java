

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static List<List<Node>> adj;
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

    static class Wolf implements Comparable<Wolf> {
        int to;
        int cost;
        int state;

        public Wolf(int to, int cost, int state) {
            this.to = to;
            this.cost = cost;
            this.state = state;
        }
        public int compareTo(Wolf o) {
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

            adj.get(a).add(new Node(b, c*2));
            adj.get(b).add(new Node(a, c*2));
        }

        int[] fox = dijkstraF(1);
        int[][] wolf = dijkstraW(1);

        int cnt=0;
        for(int i=2; i<=N; i++) {
            if(fox[i]<Math.min(wolf[i][0], wolf[i][1])) cnt++;
        }

        System.out.println(cnt);
    }

    static int[] dijkstraF(int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
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
                    pq.add(new Node(next.to, newCost));
                }
            }
        }

        return dist;
    }

    static int[][] dijkstraW(int start) {
        int[][] dist = new int[N+1][2];
        for(int i=0; i<=N; i++) Arrays.fill(dist[i], INF);

        PriorityQueue<Wolf> pq = new PriorityQueue<>();
        pq.add(new Wolf(start, 0, 0));
        dist[start][0]=0;

        while(!pq.isEmpty()) {
            Wolf curr = pq.poll();

            if(curr.cost>dist[curr.to][curr.state]) continue;

            for(Node next:adj.get(curr.to)) {
                int nextState = 1-curr.state;
                int newCost = curr.cost + (curr.state==0?next.cost/2:next.cost*2);
                if(newCost<dist[next.to][nextState]) {
                    dist[next.to][nextState]=newCost;
                    pq.add(new Wolf(next.to, newCost, nextState));
                }
            }
        }

        return dist;
    }
}
