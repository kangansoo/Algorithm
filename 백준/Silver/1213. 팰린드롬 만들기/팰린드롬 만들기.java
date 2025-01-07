import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] alphabet;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String str = br.readLine();
        char[] arr = str.toCharArray();
        alphabet = new int[26];

        for(char c:arr){
            alphabet[(c-'A')]++;
        }

        pelindrom(alphabet);
        System.out.println(sb);
    }

    static void pelindrom(int[] alpha){
        int isAvailable = 0;
        int middle=0;

        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 != 0) {
                isAvailable++;
                middle = i;
                alpha[i]--;
                if (isAvailable >= 2) {
                    sb.setLength(0);
                    sb.append("I'm Sorry Hansoo");
                    return;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alpha[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }

        String left = sb.toString();
        if (isAvailable == 1) {
            sb.append((char) (middle + 'A'));
        }
        sb.append(new StringBuilder(left).reverse());
    }

}