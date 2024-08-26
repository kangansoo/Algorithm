import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[][] deltas = {{-1, -1}, {-1, 0}, {-1, 1},{0, 1}, {1, 1}, {1, 0},{1, -1}, {0, -1}};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            int cnt = 0;

            // 1. 0인 지점부터 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] == '.' && isZero(i, j)) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            // 2. 나머지 탐색되지 않은 지점 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] == '.') {
                        cnt++;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }

    static boolean isZero(int x, int y) {
        for (int d = 0; d < 8; d++) {
            int nx = x + deltas[d][0];
            int ny = y + deltas[d][1];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == '*') {
                return false;
            }
        }
        return true;
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 8; d++) {
                int nx = cx + deltas[d][0];
                int ny = cy + deltas[d][1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    if (isZero(nx, ny)) {
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}