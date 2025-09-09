import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = bfs(x, y, n);
        return answer;
    }
    
    static int bfs(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, 0});
        boolean[] visited = new boolean[y+1];
        visited[x]=true;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currN = curr[0];
            int currT = curr[1];
            if(currN==y) {
                return currT;
            }
            
            int[] nexts = new int[]{currN+n, currN*2, currN*3};
            for(int next:nexts) {
                if(next<=y && !visited[next]) {
                    q.add(new int[]{next, currT+1});
                    visited[next]=true;
                }
            }
        }
        
        return -1;
    }
}