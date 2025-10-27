

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];

        result = 0;

        dfs(0);

        System.out.println(result);
    }

    static void dfs(int idx) {
        if(idx==N*M) {
            if(!check()) result++;
            return;
        }

        int x = idx/M;
        int y = idx%M;

        map[x][y]=true;
        dfs(idx+1);
        map[x][y]=false;
        dfs(idx+1);
    }

    static boolean check() {
        for(int i=0; i<N-1; i++) {
            for(int j=0; j<M-1; j++) {
                if(map[i][j]) {
                    if(map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
