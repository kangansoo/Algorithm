import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws NumberFormatException, IOException {
    	StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            int totalDistance = 0;

            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 'W') {
                        q.offer(new int[] {i, j, 0});
                        visited[i][j] = true;
                    }
                }
            }

            while (!q.isEmpty()) {
                int[] tmp = q.poll();
                int x = tmp[0], y = tmp[1], dist = tmp[2];

                for (int[] delta : deltas) {
                    int nx = x + delta[0];
                    int ny = y + delta[1];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                        if (map[nx][ny] == 'L') {
                            totalDistance += dist + 1;
                        }
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny, dist + 1});
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(totalDistance).append("\n");
        }
        System.out.println(sb);
    }
}