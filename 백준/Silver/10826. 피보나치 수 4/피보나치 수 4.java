import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static BigInteger[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new BigInteger[n+1];

        System.out.println(fibo(n));
    }

    static BigInteger fibo(int n){
        dp[0]=BigInteger.ZERO;
        if(n>0) dp[1] = BigInteger.ONE;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1].add(dp[i-2]);
        }
        return dp[n];
    }
}