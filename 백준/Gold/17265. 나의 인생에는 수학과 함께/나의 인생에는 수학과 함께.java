

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[][] deltas={{0, 1}, {1, 0}};
    static List<Integer> nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];
        nums = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j]=st.nextToken().charAt(0);
            }
        }

        dfs(0, 0, map[0][0]-'0');

        System.out.println(Collections.max(nums)+" "+Collections.min(nums));
    }

    static void dfs(int x, int y, int num){
        if(x==N-1 && y==N-1) {
            nums.add(num);
            return;
        }
        visited[x][y]=true;
        for(int d=0; d<2; d++) {
            int nx = x+deltas[d][0];
            int ny = y+deltas[d][1];

            if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
                if(map[x][y] == '+') {
                    dfs(nx, ny, num+(map[nx][ny]-'0'));
                } else if(map[x][y] == '-') {
                    dfs(nx, ny, num-(map[nx][ny]-'0'));
                } else if(map[x][y] == '*') {
                    dfs(nx, ny, num*(map[nx][ny]-'0'));
                } else {
                    dfs(nx, ny, num);
                }
            }
        }
        visited[x][y]=false;
    }
}
