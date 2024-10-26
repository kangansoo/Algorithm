import java.io.*;
import java.util.*;

public class Main {
    static int W, H, answer;
    static char[][] map;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;
    static Queue<int[]> fire;
    static Queue<int[]> person;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            visited = new boolean[H][W];
            fire = new LinkedList<>();
            person = new LinkedList<>();

            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '*') {
                        fire.offer(new int[]{i, j});
                    } else if (map[i][j] == '@') {
                        person.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }

            answer = bfs();
            System.out.println(answer == -1 ? "IMPOSSIBLE" : answer);
        }
    }

    static int bfs() {
        int time = 0;
        while (!person.isEmpty()) {
            time++;

            int fireSize = fire.size();
            for (int i = 0; i < fireSize; i++) {
                int[] curr = fire.poll();
                for (int[] delta : deltas) {
                    int nx = curr[0] + delta[0];
                    int ny = curr[1] + delta[1];
                    if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] != '#' && map[nx][ny] != '*') {
                        map[nx][ny] = '*';
                        fire.offer(new int[]{nx, ny});
                    }
                }
            }

            int personSize = person.size();
            for (int i = 0; i < personSize; i++) {
                int[] curr = person.poll();

                if (curr[0] == 0 || curr[0] == H-1 || curr[1] == 0 || curr[1] == W-1) {
                    return time;
                }

                for (int[] delta : deltas) {
                    int nx = curr[0] + delta[0];
                    int ny = curr[1] + delta[1];
                    if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == '.' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        person.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}