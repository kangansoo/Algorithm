import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> adj;
    static int[] dist;
    static class Node implements Comparable<Node> {
        int to;
        int cost;
        public Node(int to, int cost) {
            this.to=to;
            this.cost=cost;
        }
        
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        adj = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] p:paths) {
            int a = p[0];
            int b = p[1];
            int c = p[2];
            
            adj.get(a).add(new Node(b, c));
            adj.get(b).add(new Node(a, c));
        }
        
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        
        Set<Integer> summitSet = new HashSet<>();
        for(int s:summits) {
            summitSet.add(s);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int g:gates) {
            pq.add(new Node(g, 0));
            dist[g]=0;
        }
        
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            
            if(curr.cost>dist[curr.to]) continue;
            
            for(Node next:adj.get(curr.to)) {
                int newIntensity = Math.max(curr.cost, next.cost);
                if(newIntensity<dist[next.to]) {
                    dist[next.to] = newIntensity;
                    
                    if(!summitSet.contains(next.to)) {
                        pq.add(new Node(next.to, newIntensity));
                    }
                }
            }
        }
        
        int[] answer = {0, INF};
        for(int s:summitSet) {
            if(dist[s]<answer[1]) {
                answer[0]=s;
                answer[1]=dist[s];
            } else if(dist[s]==answer[1]) {
                answer[0] = Math.min(answer[0], s);
            }
        }
        return answer;
    }
    
}