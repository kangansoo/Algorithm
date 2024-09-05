import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, cnt, maxValue;
    static int[][] map, tmp, deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        maxValue = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        createWall(0);
        System.out.println(maxValue);
    }

    static void spread(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y]=true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int d=0; d<4; d++){
                int nx = curr[0]+deltas[d][0];
                int ny = curr[1]+deltas[d][1];

                if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny] || tmp[nx][ny]==1)continue;
                if(tmp[nx][ny]==0){
                    tmp[nx][ny]=2;
                    visited[nx][ny]=true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    static void createWall(int cnt){
        if(cnt==3){
            visited = new boolean[N][M];
            tmp = new int[N][M];
            for(int i=0; i<N; i++){
                tmp[i]=map[i].clone();
            }
            countVirus();
            return;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0){
                    map[i][j]=1;
                    createWall(cnt+1);
                    map[i][j]=0;
                }
            }
        }
    }

    static void countVirus(){
        int cnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tmp[i][j]==2){
                    spread(i, j);
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tmp[i][j]==0){
                    cnt++;
                }
            }
        }
        if(cnt>maxValue) maxValue=cnt;
    }
}