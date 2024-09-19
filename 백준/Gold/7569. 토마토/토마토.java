import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, H, max;
    static int[][][] map;
    static int[][] deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        max=0;
        map = new int[H][N][M];
        q = new LinkedList<>();

        for(int h=0; h<H; h++){
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[h][i][j] = Integer.parseInt(st.nextToken());
                    if(map[h][i][j]==1) q.add(new int[]{h, i, j});
                }
            }
        }

        bfs();

        for(int h=0; h<H; h++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[h][i][j]==0) {
                        System.out.println(-1);
                        return;
                    }else{
                        if(map[h][i][j]>max) max=map[h][i][j];
                    }
                }
            }
        }
        System.out.println(max-1);
    }

    static void bfs(){
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int h = curr[0];
            int x = curr[1];
            int y = curr[2];
            if(h-1>=0 && map[h-1][x][y]==0){
                map[h-1][x][y] = map[h][x][y]+1;
                q.offer(new int[] {h-1, x, y});
            }
            if(h+1<H && map[h+1][x][y]==0){
                map[h+1][x][y] = map[h][x][y]+1;
                q.offer(new int[] {h+1, x, y});
            }
            for(int d=0; d<4; d++){
                int nx = x+deltas[d][0];
                int ny = y+deltas[d][1];

                if(nx<0 || nx>=N || ny<0 || ny>=M || map[h][nx][ny]!=0) continue;
                map[h][nx][ny]=map[h][x][y]+1;
                q.offer(new int[] {h, nx, ny});
            }
        }
    }
}