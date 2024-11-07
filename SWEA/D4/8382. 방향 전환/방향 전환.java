import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int answer;
    static int[][] ver = {{1, 0}, {-1, 0}}, hor = {{0, 1}, {0, -1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken()) + 100;
            int sy = Integer.parseInt(st.nextToken()) + 100;
            int ex = Integer.parseInt(st.nextToken()) + 100;
            int ey = Integer.parseInt(st.nextToken()) + 100;

            answer = Integer.MAX_VALUE;

            visited = new boolean[201][201];
            bfs(sx, sy, ex, ey, 1);

            visited = new boolean[201][201];
            bfs(sx, sy, ex, ey, -1);

            sb.append("#").append(t).append(" ").append(answer == Integer.MAX_VALUE ? -1 : answer).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int sx, int sy, int ex, int ey, int direction) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy, 0, direction});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int cnt = curr[2];
            int dir = curr[3];

            if (x == ex && y == ey) {
                answer = Math.min(answer, cnt);
                return;
            }

            int[][] directions = dir == 1 ? hor : ver;
            for (int[] d : directions) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && nx < 201 && ny >= 0 && ny < 201 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, cnt + 1, -dir});
                }
            }
        }
    }
}