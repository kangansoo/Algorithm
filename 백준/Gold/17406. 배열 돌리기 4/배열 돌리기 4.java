import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K, minValue;
    static int[][] map, tmp, comm;
    static boolean[] selected;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        tmp = new int[N + 1][M + 1];
        minValue = Integer.MAX_VALUE;
        comm = new int[K][3];
        numbers = new int[K];
        selected = new boolean[K];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            comm[k][0] = r;
            comm[k][1] = c;
            comm[k][2] = s;
        }

        perm(0);

        System.out.println(minValue);
    }

    static void rotate(int r, int c, int s) {

        for (int l = 0; l < s; l++) {
            Deque<Integer>  layer = new ArrayDeque<>();
            int sx = r - s + l, sy = c - s + l;
            int ex = r + s - l, ey = c + s -l;

            for (int i = sy; i < ey; i++) layer.add(tmp[sx][i]);
            for (int i = sx; i < ex; i++) layer.add(tmp[i][ey]);
            for (int i = ey; i > sy; i--) layer.add(tmp[ex][i]);
            for (int i = ex; i > sx; i--) layer.add(tmp[i][sy]);

            layer.addFirst(layer.pollLast());

            for (int i = sy; i < ey; i++) tmp[sx][i] = layer.poll();
            for (int i = sx; i < ex; i++) tmp[i][ey] = layer.poll();
            for (int i = ey; i > sy; i--) tmp[ex][i] = layer.poll();
            for (int i = ex; i > sx; i--) tmp[i][sy] = layer.poll();
        }


    }

    static void perm(int cnt) {
        if (cnt == K) {
            for (int i = 0; i <= N; i++) {
                tmp[i] = map[i].clone(); // 각 행을 깊은 복사
            }
            for (int i = 0; i < K; i++) {
                rotate(comm[numbers[i]][0], comm[numbers[i]][1], comm[numbers[i]][2]);
            }
            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int j = 1; j <= M; j++) {
                    sum += tmp[i][j];
                }
                minValue = Math.min(minValue, sum);
            }
            return;
        }

        for (int i = 0; i < K; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            numbers[cnt] = i;
            perm(cnt + 1);
            selected[i] = false;
        }
    }
}