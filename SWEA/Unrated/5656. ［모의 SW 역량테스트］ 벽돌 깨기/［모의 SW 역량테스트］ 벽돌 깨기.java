import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N, W, H, minBlocks, totalCnt;
    static int[][] map, deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            totalCnt = 0;
            minBlocks = Integer.MAX_VALUE;

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > 0) totalCnt++;
                }
            }

            backtracking(0, totalCnt, map);

            System.out.println("#" + t + " " + minBlocks);
        }
    }

    static void backtracking(int depth, int remainingBlocks, int[][] currentMap) {
        if (remainingBlocks == 0) {
            minBlocks = 0;
            return;
        }

        if (depth == N) {
            minBlocks = Math.min(minBlocks, remainingBlocks);
            return;
        }

        int[][] copyMap = new int[H][W];

        for (int col = 0; col < W; col++) {
            copy(copyMap, currentMap);

            int topRow = findTopRow(col, copyMap);
            if (topRow == -1) {
                continue;
            }

            int broken = breakWall(topRow, col, copyMap);

            down(copyMap);

            backtracking(depth + 1, remainingBlocks - broken, copyMap);
        }
    }

    static int breakWall(int x, int y, int[][] map) {
        int broken = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y, map[x][y]});
        map[x][y] = 0;
        broken++;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            int range = current[2];

            for (int d = 0; d < 4; d++) {
                for (int r = 1; r < range; r++) {
                    int nx = cx + deltas[d][0] * r;
                    int ny = cy + deltas[d][1] * r;
                    if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] != 0) {
                        if (map[nx][ny] > 1) {
                            q.offer(new int[] {nx, ny, map[nx][ny]});
                        }
                        map[nx][ny] = 0;
                        broken++;
                    }
                }
            }
        }
        return broken;
    }

    static void down(int[][] map) {
        for (int j = 0; j < W; j++) {
            Queue<Integer> q = new LinkedList<>();
            for (int i = H - 1; i >= 0; i--) {
                if (map[i][j] > 0) q.offer(map[i][j]);
                map[i][j] = 0;
            }
            int row = H - 1;
            while (!q.isEmpty()) {
                map[row--][j] = q.poll();
            }
        }
    }

    static int findTopRow(int col, int[][] map) {
        for (int i = 0; i < H; i++) {
            if (map[i][col] > 0) return i;
        }
        return -1;
    }

    static void copy(int[][] dest, int[][] src) {
        for (int i = 0; i < H; i++) {
            dest[i] = Arrays.copyOf(src[i], W);
        }
    }
}