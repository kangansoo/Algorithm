

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, INF = Integer.MAX_VALUE;
    static List<List<Node>> adj;
    static int[][] answer;
    static public class Node implements Comparable<Node> {
        int from;
        int to;
        int cost;

        Node(int from, int to, int cost) {
            this.from = from;
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

        adj = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }

        answer = new int[N+1][N+1];

//        for(int i=0; i<=N; i++) {
//            Arrays.fill(dist[i], INF);
//        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj.get(a).add(new Node(a, b, c));
            adj.get(b).add(new Node(b, a, c));
        }


        for(int i=1; i<=N; i++) {
            answer[i] = dijkstra(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <=N; i++) {
            for (int j = 1; j <=N; j++) {
                if (i == j) {
                    sb.append('-').append(' ');
                    continue;
                }
                sb.append(answer[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, start, 0));
        int[] dist = new int[N+1];
        int[] tmp = new int[N+1];
        Arrays.fill(dist, INF);

        while(!pq.isEmpty()) {
            Node curr = pq.poll();

            if(curr.cost>dist[curr.to]) continue;

            for(Node next:adj.get(curr.to)) {
                int newCost = curr.cost+next.cost;
                if(newCost<dist[next.to]) {
                    dist[next.to]=newCost;
                    if(curr.to==start) {
                        tmp[next.to]=next.to;
                    } else {
                        tmp[next.to]=tmp[curr.to];
                    }
                    pq.add(new Node(curr.to, next.to, newCost));
                }
            }
        }

        return tmp;
    }
}
