import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, minus=0, zero=0, plus=0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    static void divide(int x, int y, int size){
        boolean flag=true;
        int initial = map[x][y];

        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if (initial != map[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        if(flag){
            if(initial == -1) minus++;
            else if(initial == 0) zero++;
            else plus++;
        }else {
            int t = size / 3;
            for (int dx = 0; dx < 3; dx++) {
                for (int dy = 0; dy < 3; dy++) {
                    divide(x + dx * t, y + dy * t, t);
                }
            }
        }
    }
}
