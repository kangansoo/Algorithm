import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[][] map, deltas={{1, -1}, {1, 0}, {1, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        result = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<3; j++){
                backtracking(0, i, j, map[0][i]);
            }
        }

        System.out.println(result);
    }

    static void backtracking(int x, int y, int d, int sum){
        if(x == N-1){
            result = Math.min(sum, result);
            return;
        }
        for(int i=0; i<3; i++){
            if(i==d) continue;
            int nx = x+deltas[i][0];
            int ny = y+deltas[i][1];
            if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
            backtracking(nx, ny, i, sum+map[nx][ny]);
        }

    }
}