import java.util.*;

class Solution {
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static char[][] map;
    static boolean[][] visited;
    static int sX=0, sY=0, width, height;
    public int solution(String[] board) {
        int answer = 0;
        
        height = board.length;
        width = board[0].length();
        
        map = new char[height][width];
        visited = new boolean[height][width];
        
        for(int i=0; i<height; i++) {
            char[] arr = board[i].toCharArray();
            map[i]=arr;
            for(int j=0; j<width; j++) {
                if(map[i][j]=='R') {
                    sX=i;
                    sY=j;
                }
            }
        }
        
        return move();
    }
    
    static int move() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sX, sY, 0});
        visited[sX][sY]=true;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            int cost = curr[2];
            
            if(map[cx][cy]=='G') return cost;
            
            for(int d=0; d<4; d++) {
                int dx = cx+deltas[d][0];
                int dy = cy+deltas[d][1];
                
                if(!isValid(dx, dy)) continue;
                
                while(true) {
                    dx += deltas[d][0];
                    dy += deltas[d][1];
                    
                    if(!isValid(dx, dy)) {
                        dx -= deltas[d][0];
                        dy -= deltas[d][1];
                        break;
                    }
                }
                
                if(visited[dx][dy]) continue;
                q.add(new int[]{dx, dy, cost+1});
                visited[dx][dy]=true;
            }
            
        }
        
        return -1;
    }
    
    static boolean isValid(int x, int y) {
        if(x<0 || y<0 || x>=height || y>=width) return false;
        if(map[x][y]=='D') return false;
        return true;
    }
}