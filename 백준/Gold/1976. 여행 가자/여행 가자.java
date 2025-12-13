

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a==1) {
                    map[i][j]=1;
                    map[j][i]=1;
                }
            }
            map[i][i]=1;
        }

        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][k]==1 && map[k][j]==1) {
                        map[i][j]=1;
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] target = new int[M];
        for(int i=0; i<M; i++) {
            int a = Integer.parseInt(st.nextToken())-1;
            target[i] = a;
        }

        boolean answer = true;
        for(int i=0; i<M-1; i++) {
            if(map[target[i]][target[i+1]]==0) {
                answer = false;
                break;
            }
        }

        System.out.println(answer?"YES":"NO");
    }
}
