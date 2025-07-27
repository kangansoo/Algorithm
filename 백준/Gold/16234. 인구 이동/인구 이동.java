import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, R, days;
    static int[][] map, deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            visited = new boolean[N][N];
            boolean moved = false;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        if(bfs(i, j)) moved=true;
                    }
                }
            }
            if(!moved) break;
            days++;
        }

        System.out.println(days);
    }

    static boolean bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y]=true;
        int tmp = map[x][y];
        int cnt = 1;

        List<int[]> union = new ArrayList<>();
        union.add(new int[]{x, y});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int nx = curr[0];
            int ny = curr[1];

            for(int d=0; d<4; d++){
                int dx = nx+deltas[d][0];
                int dy = ny+deltas[d][1];

                if(dx>=0 && dx<N && dy>=0 && dy<N && !visited[dx][dy]){
                    if(Math.abs(map[dx][dy]-map[nx][ny])>=L && Math.abs(map[dx][dy]-map[nx][ny])<=R){
                        q.add(new int[]{dx, dy});
                        union.add(new int[]{dx, dy});
                        visited[dx][dy]=true;
                        tmp+=map[dx][dy];
                        cnt++;
                    }
                }
            }
        }
        if(cnt>1){
            int avg = tmp/cnt;
            for(int[] node:union){
                map[node[0]][node[1]] = avg;
            }
            return true;
        }
        return false;
    }
}
