import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size = 4*(N-1)+1;
        map = new char[size][size];

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                map[i][j]=' ';
            }
        }

        recursion(0, N);

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    static void recursion(int start, int n) {
        if(n<=0) return;
        int end = 4*(n-1)+1;

        for(int i=start; i<end+start; i++){
                map[start][i]='*';
                map[i][start]='*';
                map[start+end-1][i]='*';
                map[i][start+end-1]='*';
        }

        recursion(start+2, n-1);
    }
}
