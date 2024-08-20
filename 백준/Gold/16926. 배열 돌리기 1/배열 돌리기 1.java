import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R;
    static int[][] arr, deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Queue<Integer> line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layers = Math.min(N, M) / 2; // 레이어 수 계산
        for (int i = 0; i < layers; i++) {
            line = new LinkedList<>();
            rotate(i); // 해당 레이어의 값들을 큐에 저장

            int len = line.size();
            for (int j = 0; j < R % len; j++) { // 회전 횟수만큼 큐를 돌림
                line.add(line.poll());
            }

            insert(i); // 회전된 큐의 값을 배열에 다시 삽입
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void rotate(int k) {
        int x = k, y = k, dir = 0;
        int ex = N - k, ey = M - k;

        do {
            line.add(arr[x][y]);

            int nx = x + deltas[dir][0];
            int ny = y + deltas[dir][1];

            if (nx < k || nx >= ex || ny < k || ny >= ey) {
                dir = (dir + 1) % 4;
                nx = x + deltas[dir][0];
                ny = y + deltas[dir][1];
            }
            x = nx;
            y = ny;
        } while (!(x == k && y == k));
    }

    private static void insert(int k) {
        int x = k, y = k, dir = 0;
        int ex = N - k, ey = M - k;

        do {
            arr[x][y] = line.poll();

            int nx = x + deltas[dir][0];
            int ny = y + deltas[dir][1];

            if (nx < k || nx >= ex || ny < k || ny >= ey) {
                dir = (dir + 1) % 4;
                nx = x + deltas[dir][0];
                ny = y + deltas[dir][1];
            }
            x = nx;
            y = ny;
        } while (!(x == k && y == k));
    }
}