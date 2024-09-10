import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        String str = br.readLine();
        boolean inTag = false;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '<') {
                result.append(sb.reverse());
                sb.setLength(0); //
                inTag = true;
                result.append(ch);
            } else if (ch == '>') {
                inTag = false;
                result.append(ch);
            } else if (inTag) {
                result.append(ch);
            } else {
                if (ch == ' ') {
                    result.append(sb.reverse());
                    sb.setLength(0);
                    result.append(' ');
                } else {
                    sb.append(ch);
                }
            }
        }

        result.append(sb.reverse());

        System.out.println(result);
    }
}