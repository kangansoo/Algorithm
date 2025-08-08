import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, D;
    static int[][] map;
    static long[][] dp;
    static long result = Long.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new long[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Long.MIN_VALUE; // 초기화
            }
        }

        for (int j = 0; j < M; j++) {
            dp[0][j] = 0;
        }

        for(int x=0; x<N; x++) {
            for(int y=0; y<M; y++) {
                for(int dx=1; dx<=D; dx++) {
                    int nx = x+dx;
                    if(nx>=N) continue;

                    int dt = D-dx;
                    for(int dy=-dt; dy<=dt; dy++) {
                        int ny = y+dy;

                        if(ny<0 || ny>=M) continue;

                        dp[nx][ny] = Math.max(dp[nx][ny], dp[x][y]+(long)map[x][y]*map[nx][ny]);
                    }
                }
            }
        }

        for(int j=0; j<M; j++) {
            result = Math.max(dp[N-1][j], result);
        }

        System.out.println(result);
    }
}
