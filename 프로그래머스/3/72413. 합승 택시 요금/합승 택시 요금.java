import java.util.*;

class Solution {
    static final int INF=Integer.MAX_VALUE;
    static int N, S, A, B;
    static int[] dist;
    static List<List<Node>> graph;
    static class Node implements Comparable<Node>{
        int to, cost;
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        public int compareTo (Node o) {
            return this.cost-o.cost;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        N=n; S=s; A=a; B=b;
        
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] fare:fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }
        
        int answer = INF;
        
        int[] distS = dijkstra(S);
        int[] distA = dijkstra(A);
        int[] distB = dijkstra(B);
        
        for(int i=1; i<=N; i++) {
            if(distS[i]==INF || distA[i]==INF || distB[i]==INF) continue;
            answer = Math.min(answer, distS[i]+distA[i]+distB[i]);
        }
        
        return answer;
    }
    
    static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue();
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start]=0;
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            
            if(dist[curr.to]<curr.cost) continue;
            
            for(Node next:graph.get(curr.to)) {
                int newDist = curr.cost+next.cost;
                if(newDist<dist[next.to]) {
                    pq.add(new Node(next.to, newDist));
                    dist[next.to]=newDist;
                }
            }
        }
        
        return dist;
    }
}