

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, ans=0;
    static boolean[][] map=new boolean[50][50];
    static int[][] deltas={{-1, -1}, {-1, 0}, {-1, 1}, {1, 1}, {1, 0}, {1, -1}};
    static int[][] next = {{1, 5}, {0, 2}, {1, 3}, {2, 4}, {3, 5}, {0, 4}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map[25][24]=true;
        dfs(24, 24, 1, 0);

        System.out.println(ans);
    }

    static void dfs(int x, int y, int curr, int cnt) {
        if(map[x][y]) {
            if(cnt==N) ans++;
            return;
        }
        if(cnt==N) return;
        map[x][y]=true;
        for(int i=0; i<2; i++) {
            int n = next[curr][i];
            dfs(x+deltas[n][0], y+deltas[n][1], n, cnt+1);
        }
        map[x][y]=false;
    }
}
