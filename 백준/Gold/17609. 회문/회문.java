

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            sb.append(check(str)).append("\n");
        }

        System.out.println(sb);
    }

    static int check(String str) {
        int l=0;
        int r=str.length()-1;

        while(l<r) {
            if(str.charAt(l)==str.charAt(r)) {
                l++;
                r--;
            } else {
                if(isPalindrome(str, l+1, r) || isPalindrome(str, l, r-1)) {
                    return 1;
                } else return 2;
            }
        }
        return 0;
    }

    static boolean isPalindrome(String str, int l, int r) {
        while(l<r) {
            if(str.charAt(l)!=str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
