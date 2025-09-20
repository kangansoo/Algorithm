import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> graph;
    static int[] dist;
    static int N;
    static class Node implements Comparable<Node>{
        int to;
        int cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
    public int solution(int n, int[][] edge) {
        N=n;
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        
        for(int i=0; i<edge.length; i++) {
            int from = edge[i][0];
            int to = edge[i][1];
            
            graph.get(from).add(new Node(to, 1));
            graph.get(to).add(new Node(from, 1));
        }
        
        dijkstra(1);
        int maxDist = 0;
        for(int i=1; i<=N; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }
        System.out.println(maxDist);
        int answer = 0;
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] == maxDist) answer++;
        }

        
        return answer;
    }
    
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start]=0;
        
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int currV = curr.to;
            int currC = curr.cost;
            
            if(currC>dist[currV]) continue;
            
            for(Node next:graph.get(currV)) {
                int newCost = next.cost+currC;
                if(newCost<dist[next.to]) {
                    pq.add(new Node(next.to, newCost));
                    dist[next.to] = newCost;
                }
            }
        }
    }
}