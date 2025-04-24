import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();

        String str = br.readLine();
        for(int i=0; i<str.length(); i++){
            stack.add(str.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            char comm = st.nextToken().charAt(0);
            switch (comm){
                case 'L':
                    if(!stack.isEmpty()) temp.add(stack.pop());
                    break;
                case 'D':
                    if(!temp.isEmpty()) stack.add(temp.pop());
                    break;
                case 'P':
                    stack.add(st.nextToken().charAt(0));
                    break;
                case 'B':
                    if(!stack.isEmpty()) stack.pop();
            }
        }

        while(!stack.isEmpty()){
            temp.add(stack.pop());
        }

        while(!temp.isEmpty()){
            sb.append(temp.pop());
        }

        System.out.println(sb);
    }
}
