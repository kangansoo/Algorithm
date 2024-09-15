import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, minValue;
    static int[][]map;
    static boolean[] selected;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        selected = new boolean[N+1];
        numbers = new int[N/2];
        minValue = Integer.MAX_VALUE;
        StringTokenizer st;

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 1);
        System.out.println(minValue);
    }

    static void comb(int depth, int start){
        if(depth == N/2){
            diff();
            return;
        }
        for(int i=start; i<=N; i++){
            if(selected[i]) continue;
            numbers[depth] = i;
            selected[i] = true;
            comb(depth+1, i+1);
            selected[i] = false;
        }
    }

    static void diff(){
        int a=0;
        int b=0;

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i!=j){
                    if(selected[i] && selected[j]){
                        a+=map[i][j];
                    }else if(!selected[i] && !selected[j]){
                        b+=map[i][j];
                    }
                }
            }
        }
        minValue = Math.min(minValue,Math.abs(a-b));
    }
}