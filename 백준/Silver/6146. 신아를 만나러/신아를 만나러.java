import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, X, Y;
    static int[][] map, deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken())+500;
        Y = Integer.parseInt(st.nextToken())+500;
        N = Integer.parseInt(st.nextToken());
        map = new int[1001][1001];
        visited = new boolean[1001][1001];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) + 500;
            int b = Integer.parseInt(st.nextToken()) + 500;
            map[a][b] = -1;
        }
        bfs();
        System.out.println(map[X][Y]);
    }
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{500, 500});
        visited[500][500]=true;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for(int d=0; d<4; d++){
                int nx = x+deltas[d][0];
                int ny = y+deltas[d][1];
                if(nx<0 || nx >=1001 || ny<0 || ny >= 1001 || visited[nx][ny] || map[nx][ny]==-1) continue;
                map[nx][ny]=map[x][y]+1;
                if(nx==X && ny==Y) return;
                visited[nx][ny]=true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}