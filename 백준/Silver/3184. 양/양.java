import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, V, O;
    static char[][] map;
    static boolean[][] visited;
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        V = 0;
        O = 0;

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            String str = br.readLine();
            map[i] = str.toCharArray();
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(!visited[i][j] && map[i][j]!='#') bfs(i, j);
            }
        }

        System.out.println(O+" "+V);
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int wolf = 0;
        int sheep = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(map[curr[0]][curr[1]] == 'v'){
                wolf++;
            } else if(map[curr[0]][curr[1]] == 'o'){
                sheep++;
            }
            for(int d=0; d<4; d++){
                int nx = curr[0] + deltas[d][0];
                int ny = curr[1] + deltas[d][1];

                if(nx>=0 && nx<R && ny>=0 && ny<C && !visited[nx][ny] && map[nx][ny]!='#'){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny]=true;
                }
            }
        }
        if(wolf>=sheep){
            V+=wolf;
        } else {
            O+=sheep;
        }
    }
}
