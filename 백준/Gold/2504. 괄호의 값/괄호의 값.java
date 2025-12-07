

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int result=0;
        int tmp=1;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            switch (ch) {
                case '(':
                    stack.push(ch);
                    tmp*=2;
                    break;
                case '[':
                    stack.push(ch);
                    tmp*=3;
                    break;
                case ')':
                    if(stack.isEmpty() || stack.peek()!='(') {
                        System.out.println(0);
                        return;
                    }
                    if(str.charAt(i-1)=='(') result+=tmp;
                    tmp/=2;
                    stack.pop();
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek()!='[') {
                        System.out.println(0);
                        return;
                    }
                    if(str.charAt(i-1)=='[') result+=tmp;
                    tmp/=3;
                    stack.pop();
                    break;
            }
        }

        if(!stack.isEmpty()) System.out.println(0);
        else System.out.println(result);
    }
}
