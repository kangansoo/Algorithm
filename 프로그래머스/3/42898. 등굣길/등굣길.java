class Solution {
    static final int MOD = 1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        boolean[][] puddle = new boolean[n][m];
        
        for(int[] p:puddles) {
            puddle[p[1]-1][p[0]-1]=true;
        }
        
        dp[0][0]=1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(puddle[i][j]) {
                    dp[i][j]=0;
                    continue;
                }
                if(i>0) dp[i][j] = (dp[i][j]+dp[i-1][j])%MOD;
                if(j>0) dp[i][j] = (dp[i][j]+dp[i][j-1])%MOD;
            }
        }
        
        return dp[n-1][m-1];
    }
}