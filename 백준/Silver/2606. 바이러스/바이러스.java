import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static boolean[] visited;
    static int[][] graph;
    static int N, M;
    static int cnt;

    public static void dfs(int x){
        visited[x] = true;
        cnt++;
        for(int i=0; i<=N; i++){
            if(graph[x][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        visited = new boolean[N+1];
        cnt = 0;
        dfs(1);
        System.out.println(cnt-1);
    }
}
