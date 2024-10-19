import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map, deltas={{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    static Queue<Cloud> clouds = new LinkedList<>();
    static boolean[][] visited;

    static class Cloud {
        int x;
        int y;
        public Cloud(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds.offer(new Cloud(N - 1, 0));
        clouds.offer(new Cloud(N - 1, 1));
        clouds.offer(new Cloud(N - 2, 0));
        clouds.offer(new Cloud(N - 2, 1));

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            move(d, s);
            increase();
            create();
        }
        int answer=0;
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                answer+=map[i][j];
            }
        }
        System.out.println(answer);
    }

    static void move(int d, int s){
        d-=1;
        for(Cloud c : clouds){
            c.x = (N+c.x+deltas[d][0]*(s%N))%N;
            c.y = (N+c.y+deltas[d][1]*(s%N))%N;
            map[c.x][c.y]++;
        }
    }
    static void increase(){
        visited = new boolean[N][N];
        while(!clouds.isEmpty()){
            Cloud c = clouds.poll();
            int cnt = 0;
            visited[c.x][c.y] = true;
            for(int d=1; d<=7; d+=2){
                int nx = c.x+deltas[d][0];
                int ny = c.y+deltas[d][1];
                if(nx<0 || nx>=N || ny<0 || ny>=N || map[nx][ny]==0) continue;
                cnt++;
            }
            map[c.x][c.y]+=cnt;
        }
    }
    static void create(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j] || map[i][j]<2) continue;
                map[i][j]-=2;
                clouds.add(new Cloud(i, j));
            }
        }
    }
}