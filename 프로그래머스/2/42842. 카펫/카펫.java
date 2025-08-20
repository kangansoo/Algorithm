import java.util.*;

class Solution {
    static int[][] map;
    public int[] solution(int brown, int yellow) {
        
        int tmp = brown+yellow;
        for(int h=3; h<=tmp; h++) {
            if(tmp%h!=0) continue;
            int w = tmp/h;
            
            if((w-2)*(h-2)==yellow) {
                return new int[] {w, h};
            }
        }
        return new int[2];
    }
}