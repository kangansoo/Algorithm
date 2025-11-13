

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, M, T;
    static List<List<Node>> adj;
    static StringBuilder sb;
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
        sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for(int t=0; t<tc; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            adj = new ArrayList<>();
            for(int i=0; i<=N; i++) {
                adj.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                adj.get(a).add(new Node(b, c));
                adj.get(b).add(new Node(a, c));
            }

            int[] des = new int[T];
            for(int i=0; i<T; i++) {
                des[i] = Integer.parseInt(br.readLine());
            }

            int[] distS = dijkstra(s);
            int[] distG = dijkstra(g);
            int[] distH = dijkstra(h);

            List<Integer> list = new ArrayList<>();

            for(int d:des) {
                int res1 = distS[g]+distG[h]+distH[d];
                int res2 = distS[h]+distH[g]+distG[d];

                if(distS[d]==res1 || distS[d]==res2) {
                    list.add(d);
                }
            }

            Collections.sort(list);
            for(int l:list) sb.append(l).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[] dijkstra(int start) {
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
}
