

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result=0;
    static int[][] map, deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(result);
    }

    static void dfs(int idx, int num) {
        if(idx==N*M) {
            result = Math.max(result, num);
            return;
        }

        int x = idx/M;
        int y = idx%M;

        if(!visited[x][y]) {
            for(int d=0; d<4; d++) {
                int nx1 = x+deltas[d][0];
                int ny1 = y+deltas[d][1];
                int nx2 = x+deltas[(d+1)%4][0];
                int ny2 = y+deltas[(d+1)%4][1];

                if(check(x, y, nx1, ny1, nx2, ny2)) {
                    visited[x][y]=true;
                    visited[nx1][ny1]=true;
                    visited[nx2][ny2]=true;
                    int sum = map[x][y]*2+map[nx1][ny1]+map[nx2][ny2];
                    dfs(idx+1, num+sum);
                    visited[x][y]=false;
                    visited[nx1][ny1]=false;
                    visited[nx2][ny2]=false;
                }
            }
        }
        dfs(idx+1, num);
    }

    static boolean check(int x, int y, int nx1, int ny1, int nx2, int ny2) {
        return(isRange(nx1, ny1) && isRange(nx2, ny2) && !visited[x][y] && !visited[nx1][ny1] && !visited[nx2][ny2]);
    }

    static boolean isRange(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }
}
