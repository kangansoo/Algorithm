import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map, deltas={{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int ans=0;
        while(!isEmpty()) {
            bfs();
            melt();
            ans++;
        }

        System.out.println(ans);
    }

    static boolean isEmpty() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]!=0) return false;
            }
        }
        return true;
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][M];

        q.add(new int[]{0, 0});
        visited[0][0]=true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int d=0; d<4; d++) {
                int dx=x+deltas[d][0];
                int dy=y+deltas[d][1];

                if(dx>=0 && dx<N && dy>=0 && dy<M && !visited[dx][dy] && map[dx][dy]==0) {
                    visited[dx][dy]=true;
                    q.add(new int[]{dx, dy});
                }
            }
        }
    }

    static void melt() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                int cnt=0;
                if(map[i][j]!=0) {
                    for(int d=0; d<4; d++) {
                        int dx=i+deltas[d][0];
                        int dy=j+deltas[d][1];

                        if(visited[dx][dy]) cnt++;
                    }
                }

                if(cnt>=2) {
                    map[i][j]=0;
                }
            }
        }
    }
}
