class Solution {
    static int[][] deltas = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
    static Block[][] map;
    static class Block {
        char cha;
        boolean isBomb;
        Block(char cha, boolean isBomb) {
            this.cha = cha;
            this.isBomb = isBomb;
        }
    }
    public int solution(int m, int n, String[] board) {
        map = new Block[m][n];
        
        for(int i=0; i<m; i++) {
            String str = board[i];
            for(int j=0; j<n; j++) {
                map[i][j] = new Block(str.charAt(j), false);
            }
        }
        
        int answer=0;

        while(true) {
            boolean isContinue = false;
            for(int i=0; i<m-1; i++) {
                for(int j=0; j<n-1; j++) {
                    if(map[i][j].cha!='.' && check(i, j)) {
                        isContinue = true;
                    }
                }
            }
            
            if(!isContinue) break;
            
            answer += boom(m, n);
            down(m, n);
        }
        
        return answer;
    }
    
    static boolean check(int x, int y) {
        char curr = map[x][y].cha;
        if (map[x][y+1].cha == curr && map[x+1][y].cha == curr && map[x+1][y+1].cha == curr) {
            for(int d=0; d<4; d++) {
                int nx = x+deltas[d][0];
                int ny = y+deltas[d][1];
                map[nx][ny].isBomb=true;
            }
            return true;
        }
        return false;
    }

    static int boom(int m, int n) {
        int cnt=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].isBomb) {
                    map[i][j] = new Block('.', false);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    static void down(int m, int n) {
        for (int j = 0; j < n; j++) {
            int emptyRow = m - 1;
            for (int i = m - 1; i >= 0; i--) {
                if (map[i][j].cha != '.') {
                    map[emptyRow][j] = map[i][j];
                    if (emptyRow != i) {
                        map[i][j] = new Block('.', false);
                    }
                    emptyRow--;
                }
            }
        }
    }
}