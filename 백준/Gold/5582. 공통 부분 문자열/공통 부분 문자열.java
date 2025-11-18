

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int N = a.length();
        int M = b.length();

        int[][] dp = new int[N+1][M+1];
        int answer = 0;

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(a.charAt(i-1)==b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        System.out.println(answer);
    }
}
