import java.util.*;

class Solution {
    static int n, m;
    static int[][] deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;
    static char[][] map;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        
        for(int i=0; i<n; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        int[] s={};
        int[] l={};
        int[] e={};
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]=='S') s = new int[]{i, j};
                if(map[i][j]=='L') l = new int[]{i, j};
                if(map[i][j]=='E') e = new int[]{i, j};
            }
        }
        
        int a = bfs(s, l);
        int b = bfs(l, e);
        if(a==-1 || b==-1) return -1;
        else return a+b;
    }
    
    static int bfs(int[] s, int[] e) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m];
        int x = s[0];
        int y = s[1];
        q.add(new int[]{x, y, 0});
        visited[x][y]=true;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            int time = curr[2];
            
            if(currX == e[0] && currY == e[1]) return time;
            
            for(int d=0; d<4; d++) {
                int nx = currX+deltas[d][0];
                int ny = currY+deltas[d][1];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && map[nx][ny]!='X') {
                    q.add(new int[]{nx, ny, time+1});
                    visited[nx][ny]=true;
                }
            }
        }
        
        return -1;
    }
}