import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

        static int N, T, value;
        static int[][] map, deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        value = N*N;
        map = new int[N][N];
        int x=0, y=0, d=0;
        int i=0, j=0;

        while(value>0){
            map[x][y]=value;

            if(value==T){
                i=x+1;
                j=y+1;
            }
            int nx = x+deltas[d][0];
            int ny = y+deltas[d][1];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != 0){
                d=(d+1)%4;
                nx = x+deltas[d][0];
                ny = y+deltas[d][1];
            }
            x=nx;
            y=ny;
            value--;

        }

        for(int[] ma:map){
            for(int m:ma){
                System.out.print(m+" ");
            }
            System.out.println();
        }
        System.out.println(i+" "+j);

    }
}