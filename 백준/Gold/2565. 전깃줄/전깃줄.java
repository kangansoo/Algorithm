

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] lines = new int[N][2];

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lines[i][0]=a;
            lines[i][1]=b;
        }

        Arrays.sort(lines, (a, b)->a[0]-b[0]);

        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(lines[j][1]<lines[i][1]) {
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int lis = 0;
        for(int i=0; i<N; i++) {
            lis = Math.max(lis, dp[i]);
        }

        System.out.println(N-lis);
    }
}
