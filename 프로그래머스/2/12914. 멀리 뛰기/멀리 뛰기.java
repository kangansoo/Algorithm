class Solution {
    static final long num=1234567;
    public long solution(int n) {
        long[] dp = new long[n+2];
        dp[1]=1;
        dp[2]=2;
        
        for(int i=3; i<=n; i++) {
            dp[i]=(dp[i-1]+dp[i-2])%num;
        }
        
        return dp[n];
    }
}