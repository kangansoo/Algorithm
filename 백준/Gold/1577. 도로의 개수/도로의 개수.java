import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[][] dp;
    static int[][] street1, street2, deltas={{1, 0}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new long[N+1][M+1];

        for(int i=0; i<=N; i++) {
            for(int j=0; j<=M; j++) {
                dp[i][j]=-1;
            }
        }

        K = Integer.parseInt(br.readLine());
        street1 = new int [K][2];
        street2 = new int [K][2];
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            street1[i][0]=a;
            street1[i][1]=b;
            street2[i][0]=c;
            street2[i][1]=d;
        }

        System.out.println(dfs(0, 0));

    }

    static long dfs(int x, int y) {
        if(x==N && y==M) {
            return 1;
        };
        if(dp[x][y]!=-1) return dp[x][y];

        dp[x][y]=0;

        for(int d=0; d<2; d++) {
            int nx = x+deltas[d][0];
            int ny = y+deltas[d][1];

            if(nx>=0 && nx<=N && ny>=0 && ny<=M) {
                if(!check(x, y, nx, ny)) continue;
                dp[x][y]+=dfs(nx, ny);
            }
        }

        return dp[x][y];
    }

    static boolean check(int x, int y, int nx, int ny) {
        for(int i=0; i<K; i++) {
            if ((x == street1[i][0] && y == street1[i][1] && nx == street2[i][0] && ny == street2[i][1]) ||
                    (nx == street1[i][0] && ny == street1[i][1] && x == street2[i][0] && y == street2[i][1])) {
                return false;
            }
        }
        return true;
    }
}
