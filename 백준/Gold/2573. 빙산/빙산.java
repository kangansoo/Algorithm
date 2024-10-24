import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, year;
    static int[][] map, tmp, deltas= {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        year = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            visited = new boolean[N][M];
            int cnt = countIce();
            if(cnt==0){
                year=0;
                break;
            }else if(cnt>1){
                break;
            }
            melt();
            year++;
        }
        System.out.println(year);
    }

    static void melt(){
        tmp = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int cnt = 0;
                if(map[i][j]!=0){
                    for(int d=0; d<4; d++){
                        int nx = i + deltas[d][0];
                        int ny = j + deltas[d][1];

                        if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                        if(map[nx][ny]==0) cnt++;
                    }
                    tmp[i][j] = map[i][j]-cnt;
                    if(tmp[i][j]<0) tmp[i][j] = 0;
                }
            }
        }
        map = tmp;
    }

    static int countIce(){
        int cnt=0;
        for(int i=0; i<N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j]!=0 && !visited[i][j]){
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j]=true;
        while(!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            for(int d=0; d<4; d++){
                int nx = x+deltas[d][0];
                int ny = y+deltas[d][1];
                if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny] || map[nx][ny]==0) continue;
                visited[nx][ny]=true;
                q.add(new int[]{nx, ny});
            }
        }
    }
}