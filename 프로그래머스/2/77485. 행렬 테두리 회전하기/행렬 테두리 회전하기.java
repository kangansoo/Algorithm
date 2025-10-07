import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] map = new int[rows][columns];
        int num=1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                map[i][j]=num++;
            }
        }
        
        int idx=0;
        for(int[] query:queries) {
            int x1 = query[0]-1;
            int y1 = query[1]-1;
            int x2 = query[2]-1;
            int y2 = query[3]-1;
            
            int prev = map[x1][y1];
            int min = prev;
            
            for(int y=y1+1; y<=y2; y++) {
                int tmp = map[x1][y];
                map[x1][y] = prev;
                prev=tmp;
                min = Math.min(prev, min);
            }
            
            for(int x=x1+1; x<=x2; x++) {
                int tmp = map[x][y2];
                map[x][y2]=prev;
                prev=tmp;
                min = Math.min(prev, min);
            }
            
            for(int y=y2-1; y>=y1; y--) {
                int tmp = map[x2][y];
                map[x2][y] = prev;
                prev=tmp;
                min = Math.min(prev, min);
            }
            
            for(int x=x2-1; x>=x1; x--) {
                int tmp = map[x][y1];
                map[x][y1]=prev;
                prev=tmp;
                min = Math.min(prev, min);
            }
            
            answer[idx++]=min;
        }
        
        
        
        return answer;
    }
}