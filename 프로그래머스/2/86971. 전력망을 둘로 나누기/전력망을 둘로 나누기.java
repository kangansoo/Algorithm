import java.util.*;

class Solution {
    static int N;
    static List<List<Integer>> graph;
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        N=n;
        
        graph = new ArrayList<>();
        
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<N-1; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for(int i=0; i<N-1; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));
            
            int cnt = count(1);
            
            answer = Math.min(answer, Math.abs(cnt-(N-cnt)));
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        return answer;
    }
    
    static int count(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N+1];
        q.add(start);
        visited[start]=true;
        int cnt=1;
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int next:graph.get(curr)) {
                if(!visited[next]) {
                    q.add(next);
                    visited[next]=true;
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}