import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] deltas={{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static int[][][] cctvDirections = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };
    static List<Cctv> cctvList;
    static class Cctv {
        int x;
        int y;
        int n;
        public Cctv(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        cctvList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n>0 && n<6) {
                    cctvList.add(new Cctv(i, j, n));
                }
                map[i][j]=n;
            }
        }

        dfs(0, map);

        System.out.println(answer);
    }

    static void dfs(int depth, int[][]map) {
        if(depth==cctvList.size()) {
            answer = Math.min(check(map), answer);
            return;
        }

        Cctv cctv = cctvList.get(depth);
        int[][] direction = cctvDirections[cctv.n];
        for(int[] dir:direction) {
            int[][] newMap = copyMap(map);
            for(int d:dir) {
                watch(cctv, d, newMap);
            }
            dfs(depth+1, newMap);
        }

    }

    static void watch(Cctv cctv, int d, int[][] map) {
        int nx = cctv.x + deltas[d][0];
        int ny = cctv.y + deltas[d][1];
        while (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 6) {
            if(map[nx][ny]==0) {
                map[nx][ny]=9;
            }
            nx += deltas[d][0];
            ny += deltas[d][1];
        }
    }

    static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            newMap[i] = map[i].clone();
        }
        return newMap;
    }

    static int check(int[][] map) {
        int num=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0) num++;
            }
        }
        return num;
    }
}
