class Solution {
    static boolean[][] counted;
    static int cntZero=0, cntOne=0;
    public int[] solution(int[][] arr) {
        int[] answer = {};
        int size = arr.length;
        counted = new boolean[size][size];
        
        recur(0, 0, size, arr);
        
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(counted[i][j]) continue;
                if(arr[i][j]==0) cntZero++;
                else cntOne++;
            }
        }
        
        return new int[]{cntZero, cntOne};
    }
    
    static void recur(int r, int c, int size, int[][] arr) {
        if(size==1) return;
        int tmp=arr[r][c];
        boolean flag=true;
        for(int i=r; i<r+size; i++) {
            for(int j=c; j<c+size; j++) {
                if(arr[i][j]!=tmp) {
                    flag=false;
                    break;
                }
            }
        }
        
        if(!flag) {
            int half = size/2;
            recur(r, c, half, arr);
            recur(r+half, c, half, arr);
            recur(r, c+half, half, arr);
            recur(r+half, c+half, half, arr);
        } else {
            for(int i=r; i<r+size; i++) {
                for(int j=c; j<c+size; j++) {
                    counted[i][j]=true;
                }
            }
            if(arr[r][c]==0) cntZero++;
            else cntOne++;
        }
        
    }
}