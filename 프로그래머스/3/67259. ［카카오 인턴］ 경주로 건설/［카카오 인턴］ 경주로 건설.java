import java.util.*;

class Solution {
    static int n, answer = Integer.MAX_VALUE;
    static int[][][] dist;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static class Node {
        int x;
        int y;
        int cost;
        int dir;
        public Node (int x, int y, int cost, int dir) {
            this.x=x;
            this.y=y;
            this.cost=cost;
            this.dir=dir;
        }
    }
    public int solution(int[][] board) {
        n = board.length;
        
        dist = new int[n][n][4];
        
        for(int[][] d2:dist) {
            for(int[] d1:d2) Arrays.fill(d1, Integer.MAX_VALUE);
        }
        
        simul(board);
        
        return answer;
    }
    
    static void simul(int[][] board) {
        Queue<Node> pq = new LinkedList<>();
        pq.add(new Node(0, 0, 0, -1));
        
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            
            if(curr.dir!=-1 && dist[curr.x][curr.y][curr.dir] < curr.cost) continue;
            
            if(curr.x==n-1 && curr.y==n-1) {
                answer = Math.min(answer, curr.cost);
            }
            
            for(int d=0; d<4; d++) {
                int dx = curr.x+deltas[d][0];
                int dy = curr.y+deltas[d][1];
                
                if(dx<0 || dy<0 || dx>=n || dy>=n || board[dx][dy]==1) continue;
                
                int newCost = curr.cost + 100;
                if(curr.dir != -1 && curr.dir!=d) newCost+=500;
                
                if (dist[dx][dy][d] > newCost) {
                    dist[dx][dy][d] = newCost;
                    pq.add(new Node(dx, dy, newCost, d));
                }
            }
        }
    }
}