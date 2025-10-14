import java.util.*;

class Solution {
    static int N, M;
    static boolean[][] isContainer;
    static char[][] map;
    static int[][] deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();
        isContainer = new boolean[N+2][M+2];
        map = new char[N+2][M+2];
        
        for(int i=1; i<=N; i++) {
            String str = storage[i-1];
            for(int j=1; j<=M; j++) {
                map[i][j]=str.charAt(j-1);
                isContainer[i][j]=true;
            }
        }
        
        for(String r:requests) {
            if(r.length()==1) {
                char comm = r.charAt(0);
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{0, 0});
                boolean[][] visited = new boolean[N+2][M+2];
                visited[0][0]=true;
                
                while(!q.isEmpty()) {
                    int[] curr = q.poll();
                    int x=curr[0];
                    int y=curr[1];
                    
                    for(int d=0; d<4; d++) {
                            int nx = x+deltas[d][0];
                            int ny = y+deltas[d][1];
                            if(nx>=0 && nx<=N+1 && ny>=0 && ny<=M+1 && !visited[nx][ny]) {
                                visited[nx][ny]=true;
                                if(isContainer[nx][ny]) {
                                    if(map[nx][ny]==comm) {
                                        isContainer[nx][ny]=false;
                                    }
                                } else {
                                    q.add(new int[]{nx, ny});
                                }
                            }
                    }
                }
            } else {
                char comm = r.charAt(0);
                
                for(int i=1; i<=N; i++) {
                    for(int j=1; j<=M; j++) {
                        if(isContainer[i][j] && map[i][j]==comm) {
                            isContainer[i][j]=false;
                        }
                    }
                }
            }
        }
        
        
        int answer = 0;
        
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(isContainer[i][j]) {
                    answer++;
                    System.out.print(map[i][j]);
                }
            }
        }
        
        return answer;
    }
}