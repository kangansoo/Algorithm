class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right-left+1);
        int[] answer = new int[size];
        
        int idx=0;
        for(long k=left; k<=right; k++) {
            int row = (int)(k/n);
            int col = (int)(k%n);
            
            answer[idx++] = Math.max(row, col)+1;
        }
        
        return answer;
    }
}