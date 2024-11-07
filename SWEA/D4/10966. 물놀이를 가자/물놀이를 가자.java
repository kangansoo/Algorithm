import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, answer;
    static int[][] deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        q = new LinkedList<>();
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            visited = new boolean[N][M];
            answer=0;
            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<M; j++){
                    map[i][j]=str.charAt(j);
                    if(map[i][j]=='W'){
                        q.offer(new int[]{i, j, 0});
                        visited[i][j]=true;
                    }
                }
            }
            bfs();
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(){
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int cnt = curr[2];
            if(map[x][y]=='L'){
                answer+=cnt;
            }
            for(int d=0; d<4; d++){
                int nx = x+deltas[d][0];
                int ny = y+deltas[d][1];
                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx, ny, cnt+1});
                }
            }

        }
    }
}