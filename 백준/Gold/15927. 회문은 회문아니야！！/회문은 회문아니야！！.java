

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();

        StringBuilder sb = new StringBuilder();
        sb.append(str);

        if(sb.reverse().toString().equals(str)) {
            boolean isFlag=true;
            char ch = str.charAt(0);
            for(int i=1; i<str.length(); i++) {
                if(ch!=str.charAt(i)) {
                    isFlag=false;
                    break;
                }
            }
            if(isFlag) {
                System.out.println(-1);
            } else {
                System.out.println(len-1);
            }
        } else {
            System.out.println(len);
        }
    }
}
