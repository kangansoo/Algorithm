import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int H=12, W=6, chainCnt;
    static int[][] deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[H][W];
        chainCnt = 0;

        for(int i=0; i<H; i++){
            String str = br.readLine();
            map[i] = str.toCharArray();
        }


        while(true) {
            boolean flag=false;
            List<int[]> bombList = new ArrayList<>();
            for(int i=H-1; i>=0; i--) {
                for(int j=0; j<W; j++) {
                    if(map[i][j]=='.') continue;
                    List<int[]> tmp = Bomb(i, j);
                    if(tmp.size()>=4) {
                        flag=true;
                        bombList.addAll(tmp);
                    }
                }
            }
            if(!flag) break;
            for(int[] bomb:bombList) {
                map[bomb[0]][bomb[1]] = '.';
            }
            chainCnt++;
            down();
        }

        System.out.println(chainCnt);
    }

    static List<int[]> Bomb(int x, int y) {
        char curChar = map[x][y];
        int cnt=1;
        Queue<int[]> q = new LinkedList<>();
        List<int[]> bombList = new ArrayList<>();
        boolean[][] visited = new boolean[H][W];
        visited[x][y]=true;
        q.add(new int[]{x, y});
        bombList.add(new int[]{x, y});

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int nx = curr[0];
            int ny = curr[1];

            for(int d=0; d<4; d++) {
                int dx = nx+deltas[d][0];
                int dy = ny+deltas[d][1];

                if(dx>=0 && dx<H && dy>=0 && dy<W && !visited[dx][dy]){
                    if(map[dx][dy]==curChar) {
                        cnt++;
                        q.add(new int[]{dx, dy});
                        bombList.add(new int[]{dx, dy});
                        visited[dx][dy]=true;
                    }
                }
            }
        }

        return bombList;
    }

    static void down() {
        for(int i=H-2; i>=0; i--) { // 맨 밑에서 2번 째 칸부터
            for(int j=0; j<W; j++) {
                int cnt=0;
                if(map[i][j]!='.') {
                    int dx=i;
                    while(true) {
                        dx+=1;
                        if(dx>=H || map[dx][j]!='.'){
                            break;
                        }
                        cnt+=1;
                    }
                }
                if(cnt!=0) {
                    map[i+cnt][j] = map[i][j];
                    map[i][j]='.';
                }
            }
        }
    }
}
