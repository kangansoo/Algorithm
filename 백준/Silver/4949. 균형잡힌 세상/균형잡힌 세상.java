import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack;
        String endFlag = ".";

        while(true){
            String str = br.readLine();
            if(str.equals(endFlag)) {
                System.out.println(sb);
                return;
            }
            stack = new Stack<>();

            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == '(' || str.charAt(i)=='[') {
                    stack.add(str.charAt(i));
                } else if(str.charAt(i)==')'){
                    if(stack.isEmpty() || stack.pop()!='('){
                        stack.add(str.charAt(i));
                        break;
                    }
                }
                else if(str.charAt(i)==']'){
                    if(stack.isEmpty() || stack.pop()!='['){
                        stack.add(str.charAt(i));
                        break;
                    }
                }
            }
            if(stack.isEmpty()){
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
    }
}
