import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] road:roads) {
            int from = road[0];
            int to = road[1];
            
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        
        Arrays.fill(dist, -1);
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{destination, 0});
        visited[destination]=true;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            dist[curr[0]] = curr[1];
            
            for(int next:graph.get(curr[0])) {
                if(!visited[next]) {
                    visited[next]=true;
                    q.add(new int[]{next, curr[1]+1});
                }
            }
        }
        
        for(int i=0; i<sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
}