import java.util.*;

class Solution {
    static List<int[]> points;
    static int minX=Integer.MAX_VALUE, minY=Integer.MAX_VALUE, maxX=Integer.MIN_VALUE, maxY=Integer.MIN_VALUE;
    public String[] solution(int[][] line) {
        points = new ArrayList<>();
        
        for(int i=0; i<line.length; i++) {
            for(int j=i+1; j<line.length; j++) {
                check(line[i], line[j]);
            }
        }
        
        int h = (maxY - minY + 1);
        int w = (maxX - minX + 1);
        char[][] map = new char[h][w];

        for(int i=0; i<h; i++) {
            Arrays.fill(map[i], '.');
        }
        
        for(int[] p:points) {
            map[maxY-p[1]][p[0]-minX] = '*';
        }
        
        String[] answer = new String[h];
        
        for (int i=0; i<h; i++) {
            answer[i] = new String(map[i]);
        }
        
        return answer;
    }
    
    static void check(int[] a, int[] b) {
        long A = a[0], B = a[1], E = a[2];
        long C = b[0], D = b[1], F = b[2];
        
        long p = A * D - B * C;
        if (p == 0) return;
        
        long xNum = B * F - E * D;
        long yNum = E * C - A * F;

        if (xNum % p != 0 || yNum % p != 0) return;

        long x = xNum / p;
        long y = yNum / p;
        
        int ix = (int)x;
        int iy = (int)y;
        
        minX = Math.min(minX, ix);
        maxX = Math.max(maxX, ix);
        minY = Math.min(minY, iy);
        maxY = Math.max(maxY, iy);
        
        points.add(new int[]{ix, iy});
    }
}