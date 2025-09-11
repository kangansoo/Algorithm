import java.util.*;

class Solution {
    int[][] deltas={{1,0}, {0,1}, {-1, -1}};
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        int target=n;
        
        int[][] map = new int[n][n];
        int idx=1;
        int dir=0;
        int x=-1;
        int y=0;
        while(target!=0) {
            for(int i=0; i<target; i++) {
                x+=deltas[dir][0];
                y+=deltas[dir][1];
                map[x][y]=idx++;
            }
            dir = (dir+1)%3;
            target--;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j]==0) break;
                answer.add(map[i][j]);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}