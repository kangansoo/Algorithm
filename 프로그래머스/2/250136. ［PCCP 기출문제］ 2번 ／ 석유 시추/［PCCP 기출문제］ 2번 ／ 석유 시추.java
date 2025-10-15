import java.util.*;

class Solution {
    static int N, M;
    static boolean[][] visited;
    static Set<Integer> set;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        int[] oils = new int[M];
        visited = new boolean[N][M];
                
        for(int j=0; j<M; j++) {
            for(int i=0; i<N; i++) {
                if(land[i][j]==1 && !visited[i][j]) {
                    set = new HashSet<>();
                    int cnt = bfs(land, i, j);
                    for(int s:set) oils[s]+=cnt;
                }
            }
        }
        
        int answer = 0;
        for(int o:oils) answer = Math.max(o, answer);
        return answer;
    }
    
    static int bfs(int[][] land, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j]=true;
        int cnt=1;
        set.add(j);
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            
            for(int d=0; d<4; d++) {
                int nx = x+deltas[d][0];
                int ny = y+deltas[d][1];
                
                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny]) {
                    if(land[nx][ny]==1) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny]=true;
                        cnt++;
                        set.add(ny);
                    }
                }
            }
        }
        
        return cnt;
    }
}