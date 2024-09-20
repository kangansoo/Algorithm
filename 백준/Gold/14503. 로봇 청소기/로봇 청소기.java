import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt;
    static int[][] map, deltas={{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        cnt=1;
        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, dir);

        System.out.println(cnt);
    }

    static void dfs(int x, int y, int dir){
        map[x][y]=-1;
        for(int d=0; d<4; d++){
            dir = (dir+3)%4;
            int nx = x+deltas[dir][0];
            int ny = y+deltas[dir][1];

            if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==0){
                cnt++;
                dfs(nx, ny,dir);
                return;
            }
        }
        int backDir = (dir + 2) % 4;
        int bx = x + deltas[backDir][0];
        int by = y + deltas[backDir][1];

        if (bx >= 0 && bx < N && by >= 0 && by < M && map[bx][by] != 1) {
            dfs(bx, by, dir);
        }
    }
}