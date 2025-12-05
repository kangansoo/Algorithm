

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N+2][M+2];
        int[] res = new int[2*N+2*M+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                int t = Integer.parseInt(st.nextToken());
                if(t==1) map[i][j] = -1;
                else map[i][j] = t;
            }
        }

        int cnt=1;
        for(int i=1; i<=N; i++) map[i][0] = cnt++;
        for(int i=1; i<=M; i++) map[N+1][i] = cnt++;
        for(int i=N; i>=1; i--) map[i][M+1] = cnt++;
        for(int i=M; i>=1; i--) map[0][i] = cnt++;

        cnt=1;
        for(int i=1; i<=N; i++) {
            int n = dfs(i, 0, 0);
            res[cnt]=n;
            res[n]=cnt++;
        }

        for(int i=1; i<=M; i++) {
            int n = dfs(N+1, i, 3);
            res[cnt]=n;
            res[n]=cnt++;
        }

        for(int i:res) {
            if(i==0) continue;
            System.out.print(i+" ");
        }
    }

    static int dfs(int x, int y, int dir) {
        int nx = x+deltas[dir][0];
        int ny = y+deltas[dir][1];

        if(map[nx][ny]>=1) return map[nx][ny];
        else {
            if(map[nx][ny]==0) return dfs(nx, ny, dir);
            else return dfs(nx, ny, change(dir));
        }
    }

    static int change(int dir) {
        if(dir==0) return 3;
        else if(dir==1) return 2;
        else if(dir==2) return 1;
        else return 0;
    }
}
