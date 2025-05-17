import java.util.*;

class Solution {
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;
    static Queue<int[]> q;
    static int N, M;
    public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        q = new LinkedList<>();
        q.add(new int[]{0, 0});
        
        bfs(maps);
        
        if(maps[N-1][M-1] == 0 || maps[N-1][M-1] == 1) return -1;
        return maps[N-1][M-1];
    }
    
    static void bfs(int[][] maps){
        visited = new boolean[N][M];
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            
            for(int d=0; d<4; d++){
                int dx = x + deltas[d][0];
                int dy = y + deltas[d][1];
                
                if(dx<0 || dx>=N || dy<0 || dy>=M || visited[dx][dy] || maps[dx][dy]==0) continue;
                q.add(new int[] {dx, dy});
                visited[dx][dy]=true;
                maps[dx][dy] = maps[x][y] + 1;
            }
            
        }
        
    }
}