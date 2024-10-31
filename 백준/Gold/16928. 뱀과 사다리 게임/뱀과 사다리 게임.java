import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] radders, snakes;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[101];
        radders = new int[N][2];
        snakes = new int[M][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            radders[i][0] = Integer.parseInt(st.nextToken());
            radders[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            snakes[i][0] = Integer.parseInt(st.nextToken());
            snakes[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = bfs();
        System.out.println(answer);
    }

    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        visited[1] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int now = curr[0];
            int cnt = curr[1];

            if(now == 100) return cnt;

            for(int i=1; i<=6; i++){
                int next = now + i;
                if(next > 100) continue;
                if(visited[next]) continue;

                for(int[] ladder : radders){
                    if(next == ladder[0]){
                        next = ladder[1];
                        break;
                    }
                }

                for(int[] snake : snakes){
                    if(next == snake[0]){
                        next = snake[1];
                        break;
                    }
                }

                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next, cnt+1});
                }
            }
        }
        return -1;
    }
}