import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map, dist;
    static int[][] deltas = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dist = new int[N][M]; // 거리 배열
        visited = new boolean[N][M];

        Queue<int[]> q = new LinkedList<>();

        // 입력받고 상어 위치(1인 곳)를 큐에 모두 삽입
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true; // 상어가 있는 곳은 이미 방문 처리
                }
            }
        }

        bfs(q);
        int maxValue = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(dist[i][j]>maxValue) maxValue = dist[i][j];
            }
        }

        System.out.println(maxValue);
    }

    static void bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            for(int d=0; d<8; d++){
                int nx = x + deltas[d][0];
                int ny = y + deltas[d][1];

                if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y]+1;
                q.add(new int[]{nx, ny});
            }
        }
    }
}