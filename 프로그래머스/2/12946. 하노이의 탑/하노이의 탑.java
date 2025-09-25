import java.util.*;

class Solution {
    static List<int[]> answer = new ArrayList<>();
    public int[][] solution(int n) {
        
        hanoi(n, 1, 2, 3);
        return answer.stream().toArray(int[][]::new);
    }
    
    static void hanoi(int n, int from, int via, int to) {
        if(n==0) {
            return;
        }
        hanoi(n-1, from, to, via);
        answer.add(new int[]{from, to});
        hanoi(n-1, via, from, to);
    }
}