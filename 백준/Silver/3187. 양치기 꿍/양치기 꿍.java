import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static char[][] map;
    static int R, C, K, V;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K=0;
        V=0;

        map = new char[R][C];
        visited = new boolean[R][C];

        String str;
        for(int i=0; i<R; i++){
            str = br.readLine();
            map[i]=str.toCharArray();
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]!='#' && !visited[i][j]){
                    bfs(i, j);
                }
            }
        }

        System.out.println(K+" "+V);

    }

    static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j]=true;

        int wolf=0;
        int sheep=0;
        if(map[i][j]=='v') wolf++;
        else if(map[i][j]=='k') sheep++;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int d=0; d<4; d++){
                int nx = x+deltas[d][0];
                int ny = y+deltas[d][1];

                if(nx>=0 && nx<R && ny>=0 && ny<C && !visited[nx][ny] && map[nx][ny]!='#'){
                    if(map[nx][ny]=='v') wolf++;
                    else if(map[nx][ny]=='k') sheep++;
                    visited[nx][ny]=true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        if(sheep>wolf){
            K+=sheep;
        }else if(sheep<=wolf){
            V+=wolf;
        }
    }
}