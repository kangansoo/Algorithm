import java.util.*;

class Solution {
    static int N, cnt=0;
    static List<List<Integer>> graph;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        N = n;
        visited = new boolean[N];
        graph = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(computers[i][j]==1) {
                    if(i==j) continue;
                    graph.get(i).add(j);
                }
            }
        }
        
        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                check(i);
                answer++;
            }
        }
        
        
        return answer;
    }
    
    static void check(int num) {
        Queue<Integer> q = new LinkedList<>();
        visited[num]=true;
        q.add(num);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int next:graph.get(curr)) {
                if(!visited[next]) {
                    q.add(next);
                    visited[next]=true;
                }
            }
        }
        
    }
}