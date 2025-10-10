import java.util.*;

class Solution {
    static int[] answer;
    static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int[] solution(String[][] places) {
        answer = new int[]{1, 1, 1, 1, 1};
        
        for(int p=0; p<5; p++) {
            String[] place = places[p];
            char[][] map = new char[5][5];
            
            for(int i=0; i<5; i++) {
                map[i] = place[i].toCharArray();
            }
            
            if(!isPossible(map)) answer[p]=0;
        }
        
        return answer;
    }
    
    static boolean isPossible(char[][] map) {
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(map[i][j]=='P') {
                    if(!bfs(map, i, j)) return false;
                }
            }
        }
        return true;
    }
    
    static boolean bfs(char[][] map, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        boolean[][] visited = new boolean[5][5];
        visited[x][y]=true;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            
            if(!(currX==x && currY==y) && map[currX][currY]=='P') return false;
            
            for(int d=0; d<4; d++) {
                int nx=currX+deltas[d][0];
                int ny=currY+deltas[d][1];
                
                if(nx>=0 && nx<5 && ny>=0 && ny<5 && map[nx][ny]!='X' && !visited[nx][ny]) {
                    if(Math.abs(x-nx)+Math.abs(y-ny)<=2) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny]=true;    
                    }
                }
            }
        }
        return true;
    }
}