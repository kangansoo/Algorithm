import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE;
    static int n, k;
    static int[] dist;
    static List<List<Node>> graph;
    static class Node implements Comparable<Node>{
        int to;
        int cost;
        public Node(int to, int cost) {
            this.to=to;
            this.cost=cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
    public int solution(int N, int[][] road, int K) {
        n=N;
        k=K;
        graph = new ArrayList<>();
        dist = new int[n+1];
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        Arrays.fill(dist, INF);
        
        for(int[] roads:road) {
            int from = roads[0];
            int to = roads[1];
            int cost = roads[2];
            
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }
        
        dijkstra(1);
        
        int answer = 0;
        
        for(int i=1; i<=n; i++) {
            if(dist[i]<=k) answer++;
        }

        return answer;
    }
    
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int currV = curr.to;
            int currC = curr.cost;
            
            if(currC>dist[currV]) continue;
            
            for(Node next:graph.get(currV)) {
                int newDist = currC+next.cost;
                if(newDist<dist[next.to]) {
                    dist[next.to] = newDist;
                    pq.add(new Node(next.to, newDist));
                }
            }
        }
    }
}