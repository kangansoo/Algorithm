import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map, deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        bfs(0, 0);
        System.out.println(map[N-1][M-1]);
    }

    static void bfs(int x, int y){
        q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] nm = q.poll();
            for(int d=0; d<4; d++){
                int nx = nm[0] + deltas[d][0];
                int ny = nm[1] + deltas[d][1];
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(map[nx][ny]==1 && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    map[nx][ny]=map[nm[0]][nm[1]]+1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}