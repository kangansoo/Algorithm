class Solution {
    static int[] peach, lion, answer;
    static int maxValue=-1;
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        lion = new int[11];
        peach = info.clone();
        
        dfs(10, n);
        if(maxValue==-1) return new int[]{-1};
        return answer;
    }
    
    static void dfs(int idx, int n) {
        if(idx==-1) {
            int lScore=0;
            int pScore=0;
            
            for(int i=0; i<11; i++) {
                if(lion[i]==0 && peach[i]==0) continue;
                if(lion[i]>peach[i]) lScore += 10-i;
                else pScore += 10-i;
            }
            if(lScore>pScore) {
                if(lScore-pScore>maxValue) {
                    maxValue = lScore-pScore;
                    answer = lion.clone();
                }
            }
            return;
        }
        for(int i=n; i>=0; i--) {
            lion[idx]=i;
            dfs(idx-1, n-i);
        }
    }
}