import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] arr, deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 시계 방향으로 둘레를 추출하기 위한 벡터
    static Queue<Integer> line; // 2차원 배열의 둘레

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 입력 변수 초기화
        M = Integer.parseInt(st.nextToken()); // 입력 변수 초기화
        R = Integer.parseInt(st.nextToken()); // 입력 변수 초기화
        arr = new int[N][M]; // 입력 배열 초기화

        for (int i = 0; i < N; i++) { // 입력 배열 받기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int lineCnt = Math.min(N, M) / 2; // 둘레 수 계산(행, 열 중 작은 값이 기준)
        for (int i = 0; i < lineCnt; i++) {
            line = new LinkedList<>(); // 둘레(레이어)
            rotate(i); // 해당 레이어의 값들을 큐에 저장

            int len = line.size();
            for (int j = 0; j < R % len; j++) { // 회전 횟수만큼 큐를 회전
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

    // 둘레 회전
    private static void rotate(int k) {
        int x = k, y = k, dir = 0; //레이어 시작 좌표(0, 0), (1, 1), ..., 방향 값
        int ex = N - k, ey = M - k; // 레이어 끝 행열 좌표(N, M), (N-1, M-1), ...

        // 초기 값부터 끝 값까지 탐색하며 큐에 저장
        do {
            line.add(arr[x][y]); // 첫 번째 값 큐에 삽입

            int nx = x + deltas[dir][0]; // 다음 값
            int ny = y + deltas[dir][1]; // 다음 값

            if (nx < k || nx >= ex || ny < k || ny >= ey) { // 범위 내 탐색
                dir = (dir + 1) % 4;
                nx = x + deltas[dir][0];
                ny = y + deltas[dir][1];
            }
            x = nx;
            y = ny;
        } while (!(x == k && y == k)); // 초기 값을 만나면 종료
    }

    // 회전시킨 큐 삽입
    private static void insert(int k) {
        int x = k, y = k, dir = 0; // 시작 좌표, 방향 벡터 값
        int ex = N - k, ey = M - k; // 마지막 좌표

        do {
            arr[x][y] = line.poll(); // 회전 시킨 큐의 값을 차례로 삽입

            int nx = x + deltas[dir][0];
            int ny = y + deltas[dir][1];

            if (nx < k || nx >= ex || ny < k || ny >= ey) { // 범위 내 탐색
                dir = (dir + 1) % 4;
                nx = x + deltas[dir][0];
                ny = y + deltas[dir][1];
            }
            x = nx;
            y = ny;
        } while (!(x == k && y == k)); // 다음 좌표가 시작 좌표라면 종료
    }
}