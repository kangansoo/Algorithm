import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, white, blue;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        white=0;
        blue=0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(white+"\n"+blue);
    }

    static void divide(int x, int y, int size){
        int sum=0;

        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                sum+=map[i][j];
            }
        }

        if(sum==0){
            white++;
        } else if(sum==size*size){
            blue++;
        } else {
            int half = size/2;
            divide(x, y, half);
            divide(x+half, y, half);
            divide(x, y+half, half);
            divide(x+half, y+half, half);
        }
    }
}