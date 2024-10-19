import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, T;
    static int[][] map, tmp;
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static AirCleaner[] ac = new AirCleaner[2];

    static class AirCleaner {
        int x;
        int y;
        public AirCleaner(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    ac[idx++] = new AirCleaner(i, j);
                }
            }
        }

        for (int t = 0; t < T; t++) {
            spread();
            clean();
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) result += map[i][j];
            }
        }
        System.out.println(result);
    }

    static void spread() {
        tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    int amount = map[i][j] / 5;
                    int cnt = 0;
                    for (int[] d : deltas) {
                        int nx = i + d[0], ny = j + d[1];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != -1) {
                            tmp[nx][ny] += amount;
                            cnt++;
                        }
                    }
                    tmp[i][j] += map[i][j] - amount * cnt;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != -1) {
                    map[i][j] = tmp[i][j];
                }
            }
        }
    }

    static void clean() {
        for (int i = ac[0].x - 1; i > 0; i--) map[i][0] = map[i-1][0];
        for (int j = 0; j < M - 1; j++) map[0][j] = map[0][j+1];
        for (int i = 0; i < ac[0].x; i++) map[i][M-1] = map[i+1][M-1];
        for (int j = M - 1; j > 1; j--) map[ac[0].x][j] = map[ac[0].x][j-1];
        map[ac[0].x][1] = 0;

        for (int i = ac[1].x + 1; i < N - 1; i++) map[i][0] = map[i+1][0];
        for (int j = 0; j < M - 1; j++) map[N-1][j] = map[N-1][j+1];
        for (int i = N - 1; i > ac[1].x; i--) map[i][M-1] = map[i-1][M-1];
        for (int j = M - 1; j > 1; j--) map[ac[1].x][j] = map[ac[1].x][j-1];
        map[ac[1].x][1] = 0;
    }
}