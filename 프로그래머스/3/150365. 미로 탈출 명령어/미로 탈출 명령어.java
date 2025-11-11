import java.util.*;

class Solution {
    static int N, M, R, C, K;
    static int[][] deltas={{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    static char[] dir = {'d', 'l', 'r', 'u'};
    static boolean isSolved;
    static String answer;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N=n;
        M=m;
        R=r-1;
        C=c-1;
        K=k;
        isSolved=false;
        answer="";
        
        dfs(x-1, y-1, 0, new StringBuilder());
        
        if(isSolved) return answer;
        else return "impossible";
    }
    
    static void dfs(int x, int y, int depth, StringBuilder sb) {
        if(isSolved) return;
        if(depth==K) {
            if(x==R && y==C) {
                answer = sb.toString();
                isSolved=true;
            }
        }
        
        int remain = Math.abs(x-R)+Math.abs(y-C);
        if(remain>K-depth || (remain-K-depth)%2!=0) return;
        
        for(int d=0; d<4; d++) {
            int nx = x+deltas[d][0];
            int ny = y+deltas[d][1];
            
            if(nx>=0 && nx<N && ny>=0 && ny<M) {
                sb.append(dir[d]);
                dfs(nx, ny, depth+1, sb);
                sb.deleteCharAt(sb.length()-1);
                if(isSolved) return;
            }
        }
    }
}