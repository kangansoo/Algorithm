import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, max;
    static int[][] map, deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        max=0;
        map = new int[N][M];
        q = new LinkedList<>();
        boolean noResult = true;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) q.add(new int[]{i, j});
            }
        }

        bfs();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0) {
                    System.out.println(-1);
                    return;
                }else{
                    if(map[i][j]>max) max=map[i][j];
                }
            }
        }
        System.out.println(max-1);
    }

    static void bfs(){
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for(int d=0; d<4; d++){
                int nx = x+deltas[d][0];
                int ny = y+deltas[d][1];

                if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny]!=0) continue;
                map[nx][ny]=map[x][y]+1;
                q.offer(new int[] {nx, ny});
            }

        }
    }
}