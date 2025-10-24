

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] map;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean isSolved=false;
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                char c = st.nextToken().charAt(0);
                if(c=='T') list.add(new int[]{i, j});
                map[i][j] = c;
            }
        }

        int[][] walls = new int[3][2];

        dfs(0, 0, walls);

        System.out.println(isSolved?"YES":"NO");
    }

    static void dfs(int depth, int idx, int[][] walls) {
        if(isSolved) return;
        if(depth==3) {
            for(int[] wall:walls) {
                map[wall[0]][wall[1]]='O';
            }

            if(simulation()) {
                isSolved=true;
            }

            for(int[] wall:walls) {
                map[wall[0]][wall[1]]='X';
            }

            return;
        }

        for(int i=idx; i<N*N; i++) {
            int r = i/N;
            int c = i%N;
            if(map[r][c]=='X') {
                walls[depth][0]=r;
                walls[depth][1]=c;
                dfs(depth+1, i+1, walls);
                if (isSolved) return;
            }
        }
    }

    static boolean simulation() {
        for(int[] t:list) {
            int x=t[0];
            int y=t[1];

            for(int d=0; d<4; d++) {
                int nx=x;
                int ny=y;
                while(true) {
                    nx += deltas[d][0];
                    ny += deltas[d][1];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;

                    if(map[nx][ny]=='O') break;
                    if(map[nx][ny]=='S') return false;
                }
            }
        }
        return true;
    }
}
