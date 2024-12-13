import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L, R, C;
    static int[][] deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static char[][][] map;
    static boolean[][][] visited;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L==0 && R==0 && C==0) break;

            map = new char[L][R][C];
            visited = new boolean[L][R][C];
            q = new LinkedList<>();

            for(int l=0; l<L; l++){
                for(int i=0; i<R; i++){
                    String str = br.readLine();
                    for(int j=0; j<C; j++){
                        map[l][i][j]=str.charAt(j);
                        if(str.charAt(j)=='S'){
                            q.add(new int[] {l, i, j, 0});
                            visited[l][i][j]=true;
                        }
                    }
                }
                br.readLine();
            }

            int result = bfs();
            if(result == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + result + " minute(s).");
            }
        }
    }

    static int bfs(){
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int h = curr[0];
            int x = curr[1];
            int y = curr[2];
            int t = curr[3];

            if(map[h][x][y]=='E'){
                return t;
            }

            int down = h-1;
            if(down>=0 && !visited[down][x][y] && map[down][x][y]!='#'){
                q.add(new int[]{down, x, y, t+1});
                visited[down][x][y]=true;
            }
            int up = h+1;
            if(up<L && !visited[up][x][y] && map[up][x][y]!='#'){
                q.add(new int[]{up, x, y, t+1});
                visited[up][x][y]=true;
            }

            for(int d=0; d<4; d++){
                int nx = x+deltas[d][0];
                int ny = y+deltas[d][1];

                if(nx>=0 && nx<R && ny>=0 && ny<C && map[h][nx][ny]!='#' && !visited[h][nx][ny]){
                    q.add(new int[]{h, nx, ny, t+1});
                    visited[h][nx][ny]=true;
                }
            }
        }
        return -1;
    }
}