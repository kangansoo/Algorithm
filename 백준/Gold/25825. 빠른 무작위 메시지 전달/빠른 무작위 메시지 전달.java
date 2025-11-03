

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dist = new int[12][12];
    static int min = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<12; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<12; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<6; i++) {
            int a = i*2;
            int b = a+1;
            int cost = dist[a][b];

            visited[i]=true;
            dfs(1, a, cost);
            dfs(1, b, cost);
            visited[i]=false;
        }

        System.out.println(min);
    }

    static void dfs(int depth, int curr, int num) {
        if(num>min) return;
        if(depth==6) {
            min = Math.min(num, min);
        }

        for(int i=0; i<6; i++) {
            if(visited[i]) continue;
            int a = i*2;
            int b = a+1;
            int cost = dist[a][b];

            visited[i] = true;
            dfs(depth+1, a, num+cost+dist[curr][b]);
            dfs(depth+1, b, num+cost+dist[curr][a]);
            visited[i]=false;
        }
    }
}
