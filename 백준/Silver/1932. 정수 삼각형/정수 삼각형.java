

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] triangle = new int[N][N];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = triangle[0][0];

        for(int i=1; i<N; i++) {
            for(int j=0; j<=i; j++) {
                if(j==0) {
                    dp[i][j] = dp[i-1][j]+triangle[i][j];
                } else if(i==j) {
                    dp[i][i] = dp[i-1][i-1]+triangle[i][i];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1])+triangle[i][j];
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[N-1][i]);
        }

        System.out.println(answer);
    }
}