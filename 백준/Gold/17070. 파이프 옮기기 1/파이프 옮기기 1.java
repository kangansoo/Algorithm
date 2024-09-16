import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, cnt;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        cnt=0;

        for(int i = 0; i < N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1, 0);
        System.out.println(cnt);

    }

    static void dfs(int x, int y, int state){
        if(x==N-1 && y==N-1){
            cnt++;
        }
        if(state==0){
            if(y+1<N && map[x][y+1]==0){
                dfs(x, y+1, 0);
            }
        }else if(state==1){
            if(y+1<N && map[x][y+1]==0){
                dfs(x, y+1, 0);
            }
            if(x+1<N && map[x+1][y]==0){
                dfs(x+1, y, 2);
            }
        }else if(state==2){
            if(x+1<N && map[x+1][y]==0){
                dfs(x+1, y, 2);
            }
        }
        if(x+1<N && y+1<N && map[x+1][y+1]==0 && map[x+1][y]==0 && map[x][y+1]==0){
            dfs(x+1, y+1, 1);
        }

    }
}