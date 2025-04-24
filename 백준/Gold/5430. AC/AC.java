import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int N, length;
    static String[] numbers;
    static String comm, input;
    static boolean isError, isReverse;
    static Deque<Integer> dq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            isError = false;
            isReverse = false;
            dq = new ArrayDeque<>();
            comm = br.readLine();
            N = Integer.parseInt(br.readLine());
            length = 2*N+1;
            input = br.readLine();
            input = input.substring(1, input.length()-1);
            if(!input.isEmpty()){
                numbers = input.split(",");
                for(String num : numbers){
                    dq.add(Integer.parseInt(num));
                }
            }

            for(int i=0; i<comm.length(); i++){
                if(comm.charAt(i)=='D'){
                    if(dq.isEmpty()){
                        sb.append("error").append("\n");
                        isError=true;
                        break;
                    } else {
                        if(!isReverse){
                            dq.poll();
                        } else {
                            dq.pollLast();
                        }
                    }
                } else {
                    isReverse=!isReverse;
                }
            }

            if(!isError){
                sb.append('[');
                while(!dq.isEmpty()){
                    sb.append(isReverse ? dq.pollLast() : dq.pollFirst());
                    if (!dq.isEmpty()) sb.append(',');
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}
