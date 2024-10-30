import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map, deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 1});
        visited[0][0][0]=true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int broken = curr[2];
            int cnt = curr[3];

            if(x==N-1 && y==M-1) return cnt;

            for(int d=0; d<4; d++){
                int nx = x+deltas[d][0];
                int ny = y+deltas[d][1];
                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(map[nx][ny]==1 && broken==0 && !visited[nx][ny][1]){
                        visited[nx][ny][1]=true;
                        q.add(new int[]{nx, ny, 1, cnt+1});
                    }
                    else if(map[nx][ny]==0 && !visited[nx][ny][broken]){
                        visited[nx][ny][broken]=true;
                        q.add(new int[]{nx, ny, broken, cnt+1});
                    }
                }
            }
        }
        return -1;
    }
}