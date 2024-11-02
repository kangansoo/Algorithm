import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static int[][] deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        answer = 0;

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j]=str.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]=='L'){
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(int x, int y){
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        visited[x][y]=true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cnt = curr[2];
            if(cnt>answer) answer=cnt;
            for(int d=0; d<4; d++){
                int nx = curr[0]+deltas[d][0];
                int ny = curr[1]+deltas[d][1];
                if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny] || map[nx][ny]=='W') continue;
                q.offer(new int[]{nx, ny, cnt+1});
                visited[nx][ny]=true;
            }
        }
    }
}