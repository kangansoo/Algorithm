import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R1, R2, C1, C2, answer, N;
    static int[][] deltas={{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        R1 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());
        visited = new boolean[N][N];
        answer = -1;

        bfs();

        System.out.println(answer);
    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{R1, C1, 0});
        visited[R1][C1]=true;

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int x = curr[0];
            int y = curr[1];
            int cnt = curr[2];
            if(x==R2 && y==C2){
                answer=cnt;
                return;
            }

            for(int d=0; d<6; d++){
                int nx = x+deltas[d][0];
                int ny = y+deltas[d][1];
                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]){
                    q.add(new int[]{nx, ny, cnt+1});
                    visited[nx][ny]=true;
                }
            }

        }

    }
}