import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, cnt;
    static int[] col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N+1];

        setQueens(1);
        System.out.println(cnt);
    }

    static void setQueens(int rowNo){
        if(!isAvailable(rowNo-1)) return;
        if(rowNo>N){
            cnt++;
            return;
        }
        for(int i=1; i<=N; i++){
            col[rowNo]=i;
            setQueens(rowNo+1);
        }
    }

    static boolean isAvailable(int rowNo){
        for(int i=1; i<rowNo; i++){
            if(col[i]==col[rowNo] || Math.abs(col[rowNo] - col[i]) == rowNo - i) return false;
        }
        return true;
    }
}