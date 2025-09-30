class Solution {
    static int[] sales = {10, 20, 30, 40}, answer = {0, 0};
    public int[] solution(int[][] users, int[] emoticons) {
        int[] salePercent = new int[emoticons.length];
        
        dfs(0, emoticons, users, salePercent);
        
        return answer;
    }
    
    static void dfs(int depth, int[] emoticons, int[][] users, int[] salePercent) {
        if(depth==emoticons.length) {
            int num=0;
            int totalPrice=0;
            
            for(int[] user: users) {
                int pays=0;
                
                for(int i=0; i<emoticons.length; i++) {
                    if(salePercent[i]>=user[0]) {
                        pays+=emoticons[i]*(100-salePercent[i])/100;
                    }
                }
                if(pays>=user[1]) {
                    num++;
                } else {
                    totalPrice+=pays;
                }
            }
            
            if(num>answer[0] || (num==answer[0] && totalPrice>answer[1])) {
                answer[0]=num;
                answer[1]=totalPrice;
            }
            return;
        }
        
        for(int s:sales) {
            salePercent[depth] = s;
            dfs(depth+1, emoticons, users, salePercent);
        }
    }
}