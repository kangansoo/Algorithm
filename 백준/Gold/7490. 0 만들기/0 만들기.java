import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            if(t>=1) sb.append("\n");

            comb(1, "1");

        }

        System.out.println(sb);
    }

    static void comb(int n, String str){
        if(n==N){
            if(calculate(str)){
                sb.append(str).append("\n");
            }
            return;
        }
        comb(n+1, str+" "+(n+1));
        comb(n+1, str+"+"+(n+1));
        comb(n+1, str+"-"+(n+1));
    }

    static boolean calculate(String str){
        String string = str.replace(" ", "");
        int result=0;
        char op = '+';
        int tmp=0;
        for(int i=0; i<string.length(); i++){
            char cha = string.charAt(i);
            if(Character.isDigit(cha)){
                tmp = tmp*10+(cha-'0');
            }
            if(!Character.isDigit(cha) || i==string.length()-1){
               if(op=='+'){
                   result+=tmp;
               } else if(op=='-'){
                   result-=tmp;
               }
               op=cha;
               tmp=0;
            }
        }
        return result == 0;
    }
}
