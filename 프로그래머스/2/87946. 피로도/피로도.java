class Solution {
    static int N, answer = -1;
    static boolean[] isSelected;
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        isSelected = new boolean[N];
        
        perm(0, dungeons, k);
        
        return answer;
    }
    
    static void perm(int depth, int[][] dungeons, int k) {
        answer = Math.max(answer, depth);
        for(int i=0; i<N; i++) {
            if(isSelected[i]) continue;
            if(k<dungeons[i][0]) continue;
            isSelected[i]=true;
            perm(depth+1, dungeons, k-dungeons[i][1]);
            isSelected[i]=false;
        }
    }
}