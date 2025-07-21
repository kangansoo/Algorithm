import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] map;
    static int[][] deltas={{-1,0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        int cnt=0;

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=1; i<N-1; i++){
            for(int j=1; j<N-1; j++){
                if(isMine(i, j)){
                    for (int d = 0; d < 8; d++) {
                        int dx = i + deltas[d][0];
                        int dy = j + deltas[d][1];
                        if (map[dx][dy] != '#') {
                            map[dx][dy] -= 1;
                        }
                    }
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static boolean isMine(int x, int y){
        for(int d=0; d<8; d++) {
            int dx = x+deltas[d][0];
            int dy = y+deltas[d][1];

            if(map[dx][dy]=='0') return false;
        }
        return true;
    }
}
