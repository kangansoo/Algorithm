import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        divide(0, 0, N);

        System.out.println(sb);
    }

    static void divide(int x, int y, int size){
        int sum=0;

        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                sum+=map[i][j];
            }
        }

        if(sum==0){
            sb.append(0);
        } else if(sum==size*size){
            sb.append(1);
        } else {
            int half = size/2;
            sb.append("(");
            divide(x, y, half);
            divide(x, y+half, half);
            divide(x+half, y, half);
            divide(x+half, y+half, half);
            sb.append(")");
        }
    }
}
