import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] di = {1, 1, -1, -1};
    static int[] dj = {1, -1, -1, 1};
    static int N, max, map[][];
    static boolean[] dessert;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            max = -1;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dessert = new boolean[101];  // 새로운 경로 탐색 시작 전에 초기화
                    dfs(i, j, i, j, 0, 0);
                }
            }
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int i, int j, int si, int sj, int cnt, int dir) {
        if (cnt > 3 && i == si && j == sj) {  // 경로가 3보다 긴 경우에만 사각형 확인
            max = Math.max(max, cnt);
            return;
        }

        for (int d = dir; d < 4; d++) {  // 다음 방향으로 탐색
            int ni = i + di[d];
            int nj = j + dj[d];

            if (0 <= ni && ni < N && 0 <= nj && nj < N && !dessert[map[ni][nj]]) {
                dessert[map[ni][nj]] = true;  // 디저트를 먹은 것으로 표시
                dfs(ni, nj, si, sj, cnt + 1, d);
                dessert[map[ni][nj]] = false;  // 탐색 후 원상복구
            }
        }
    }
}