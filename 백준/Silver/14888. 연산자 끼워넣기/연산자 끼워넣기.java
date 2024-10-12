import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
    static int[] numbers, operators;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        operators = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            numbers[n] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            operators[i]=Integer.parseInt(st.nextToken());
        }

        backtracking(numbers[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    static void backtracking(int num, int idx){
        if(idx==N){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for(int i=0; i<4; i++){
            if(operators[i]>0){
                operators[i]--;
                switch(i){
                    case 0:
                        backtracking(num+numbers[idx], idx+1);
                        break;
                    case 1:
                        backtracking(num-numbers[idx], idx+1);
                        break;
                    case 2:
                        backtracking(num*numbers[idx], idx+1);
                        break;
                    case 3:
                        backtracking(num/numbers[idx], idx+1);
                        break;
                }
                operators[i]++;
            }
        }
    }
}