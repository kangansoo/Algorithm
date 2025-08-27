class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int len = land.length;
        
        int curr=0;
        for(int i=1; i<len; i++) {
            for(int j=0; j<4; j++) {
                int max=0;
                
                for(int n=0; n<4; n++) {
                    if(j==n) continue;
                    max = Math.max(land[i-1][n], max);
                }
                land[i][j]+=max;
            }
        }
        
        for(int i=0; i<4; i++) {
            answer=Math.max(land[len-1][i], answer);
        }

        return answer;
    }
}