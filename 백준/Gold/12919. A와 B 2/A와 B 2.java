import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        String T = br.readLine();
        answer=0;
        dfs(T);
        System.out.println(answer);
    }

    static void dfs(String str){
        if(str.length() == S.length()){
            if(str.equals(S)) {
                answer=1;
            }
            return;
        }
        if(str.charAt(str.length()-1)=='A'){
            dfs(str.substring(0, str.length() - 1));
        }
        if(str.charAt(0)=='B'){
            StringBuilder T = new StringBuilder(str);
            dfs(T.deleteCharAt(0).reverse().toString());
        }
    }
}
