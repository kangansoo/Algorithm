class Solution {
    static int answer=0;
    static int[] col;
    public int solution(int n) {
        col = new int[n];
        
        setQueens(0, n);
        
        return answer;
    }
    
    static void setQueens(int rowNo, int n) {
        if(rowNo>=n) {
            answer++;
            return;
        }
        for(int i=0; i<n; i++) {
            col[rowNo]=i;
            if(isAvailable(rowNo)) {
                setQueens(rowNo+1, n);    
            }
        }
    }
    
    static boolean isAvailable(int rowNo) {
        for(int i=0; i<rowNo; i++) {
            if(col[rowNo]==col[i] || rowNo-i==Math.abs(col[rowNo]-col[i])) return false;
        }
        return true;
    }
}