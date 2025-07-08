import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());
        int answer = 0;

        while(true){
            if(T.charAt(T.length()-1)=='A'){
                T.deleteCharAt(T.length()-1);
            } else {
                T.deleteCharAt(T.length()-1).reverse();
            }

            if(T.length()==S.length()){
                if(T.toString().equals(S)){
                    answer=1;
                }
                break;
            }
        }
        System.out.println(answer);
    }
}
