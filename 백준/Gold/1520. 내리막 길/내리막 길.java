import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map, dp, deltas={{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j]=-1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int x, int y) {
        if(x==N-1 && y==M-1) {
            return 1;
        }

        if(dp[x][y]!=-1) return dp[x][y];

        dp[x][y]=0;

        for(int d=0; d<4; d++) {
            int dx = x+deltas[d][0];
            int dy = y+deltas[d][1];

            if(dx>=0 && dx<N && dy>=0 && dy<M) {
                if(map[dx][dy]<map[x][y]) {
                    dp[x][y]+=dfs(dx, dy);
                }
            }
        }

        return dp[x][y];
    }
}
