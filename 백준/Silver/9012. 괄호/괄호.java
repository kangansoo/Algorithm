import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String str = br.readLine();
            char[] arr = str.toCharArray();
            Stack<Character> stack = new Stack<>();

            for(char cha:arr){
                if(cha=='('){
                    stack.add(cha);
                } else {
                    if(stack.isEmpty()){
                        stack.add(')');
                    } else {
                        if(stack.peek()=='('){
                            stack.pop();
                        }
                    }
                }
            }

            if(!stack.isEmpty()){
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }

        System.out.println(sb);
    }
}
