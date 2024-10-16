import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, time, cnt=0;
    static int[][] map, tmp, deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        time = 0;
        q = new LinkedList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]!=0) cnt++;
            }
        }

        int answer = 0;
        while(cnt!=0){
            visited = new boolean[N][M];
            answer = cnt;
            bfs();
            time++;
        }
        System.out.println(time);
        System.out.println(answer);
    }

    static void bfs(){
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for(int d=0; d<4; d++){
                int nx = x+deltas[d][0];
                int ny = y+deltas[d][1];
                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    if(map[nx][ny]==0){
                        q.add(new int[]{nx, ny});
                    }else {
                        map[nx][ny]=0;
                        cnt--;
                    }
                }
            }
        }
    }
}