

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[N+1][N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = true;
        }

        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                if(k==i) continue;
                for(int j=1; j<=N; j++) {
                    if(k==j) continue;
                    if(graph[i][k] && graph[k][j]) graph[i][j]=true;
                }
            }
        }


        for(int i=1; i<=N; i++) {
            int cnt=0;

            for(int j=1; j<=N; j++) {
                if(i!=j && graph[i][j]) {
                    cnt++;
                }
            }

            for(int j=1; j<=N; j++) {
                if(i!=j && graph[j][i]) cnt++;
            }

            if(cnt==N-1) answer++;
        }

        System.out.println(answer);
    }
}
