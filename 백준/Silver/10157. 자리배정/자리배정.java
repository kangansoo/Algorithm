import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[R][C];
        boolean[][] visited = new boolean[R][C];
        int num = 1;
        int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;
        int x = 0, y = 0;

        while (num <= R * C) {
            graph[x][y] = num;
            visited[x][y] = true;
            if (num == N) {
                System.out.println((x+1)+" "+(y+1));
                return;
            }
            num++;

            int nx = x + deltas[dir][0];
            int ny = y + deltas[dir][1];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny]) {
                dir = (dir + 1) % 4;  // 방향 전환
                nx = x + deltas[dir][0];
                ny = y + deltas[dir][1];
            }

            x = nx;
            y = ny;
        }
        System.out.println(0);
    }
}