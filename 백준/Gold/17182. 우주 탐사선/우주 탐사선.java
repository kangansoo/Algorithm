

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, answer=Integer.MAX_VALUE;
    static int[][] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                dist[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(dist[i][j]>dist[i][k]+dist[k][j]) {
                        dist[i][j] = dist[i][k]+dist[k][j];
                    }
                }
            }
        }

        visited = new boolean[N];
        visited[K]=true;

        dfs(K, 1, 0);

        System.out.println(answer);
    }

    static void dfs(int curr, int depth, int sum) {
        if(depth==N) {
            answer = Math.min(answer, sum);
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i]=true;
                dfs(i, depth+1, sum+dist[curr][i]);
                visited[i]=false;
            }
        }
    }
}
