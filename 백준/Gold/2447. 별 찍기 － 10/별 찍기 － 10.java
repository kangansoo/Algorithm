

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        map = new char[N][N];

        recur(0, 0, N);

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sb.append(map[i][j]=='*'?'*':' ');
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void recur(int x, int y, int size) {
        if(size==1) {
            map[x][y]='*';
            return;
        }

        int nextSize = size/3;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(i==1 && j==1) continue;

                recur(x+i*nextSize, y+j*nextSize, nextSize);
            }
        }
    }
}
