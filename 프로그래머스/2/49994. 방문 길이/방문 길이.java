class Solution {
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int solution(String dirs) {
        int answer = 0;
        
        boolean[][][] map = new boolean[11][11][4];
        
        int x=5;
        int y=5;
        int d=0;
        
        for(char chr:dirs.toCharArray()) {
            if(chr=='R') d=0;
            if(chr=='D') d=1;
            if(chr=='L') d=2;
            if(chr=='U') d=3;
            
            int nx = x+deltas[d][0];
            int ny = y+deltas[d][1];
            
            if(nx<0 || nx>10 || ny<0 || ny>10) continue;
            if(!map[x][y][d]) {
                answer+=1;
                map[x][y][d]=true;
                map[nx][ny][(d+2)%4]=true;
            }
            
            x=nx;
            y=ny;
        }
        
        return answer;
    }
}