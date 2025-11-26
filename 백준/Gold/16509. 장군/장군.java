

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] cx = {-1, 1, 1, -1};
    static int[] cy = {1, 1, -1, -1};
    static int[] king = new int[2];
    static boolean[][] visited = new boolean[10][9];
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ss = Integer.parseInt(st.nextToken());
        int se = Integer.parseInt(st.nextToken());
        q.add(new int[]{ss, se, 0});
        visited[ss][se]=true;

        st = new StringTokenizer(br.readLine());
        king[0] = Integer.parseInt(st.nextToken());
        king[1] = Integer.parseInt(st.nextToken());

        System.out.println(bfs());

    }

    static int bfs() {
        while(!q.isEmpty()) {
            int[] curr = q.poll();

            if(curr[0]==king[0] && curr[1]==king[1]) {
                return curr[2];
            }

            check(curr);
        }
        return -1;
    }

    static void check(int[] curr) {
        for(int d=0; d<4; d++) {
            int tx = curr[0]+dx[d];
            int ty = curr[1]+dy[d];

            if(isPossible(tx, ty)) {
                for(int c=0; c<2; c++) {
                    int ch = (d+c)%4;
                    int nx = tx+cx[ch];
                    int ny = ty+cy[ch];

                    if(isPossible(nx, ny)) {
                        nx += cx[ch];
                        ny += cy[ch];

                        if(inRange(nx, ny) && !visited[nx][ny]) {
                            visited[nx][ny]=true;
                            q.add(new int[] {nx, ny, curr[2]+1});
                        }
                    }
                }
            }
        }
    }

    static boolean isPossible(int x, int y) {
        if(x==king[0] && y==king[1]) return false;
        return inRange(x, y);
    }

    static boolean inRange(int x, int y) {
        return x>=0 && x<10 && y>=0 && y<9;
    }
}
