

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        dfs(num, 0);

        System.out.println(min+" "+max);
    }

    static void dfs(int n, int cnt) {
        cnt+=countOdd(n);

        if(n/10==0) {
            min = Math.min(cnt, min);
            max = Math.max(cnt, max);
        } else if(n/100==0) {
            int next = n/10;
            next += n%10;
            dfs(next, cnt);
        } else {
            String str = String.valueOf(n);
            for(int i=0; i<str.length()-2; i++) {
                for(int j=i+1; j<str.length()-1; j++) {
                    int next = Integer.parseInt(str.substring(0, i+1));
                    next += Integer.parseInt(str.substring(i+1, j+1));
                    next += Integer.parseInt(str.substring(j+1));
                    dfs(next, cnt);
                }
            }
        }
    }

    static int countOdd(int n) {
        int cnt=0;
        while(n>0) {
            int tmp = n%10;
            if(tmp%2==1) cnt++;
            n/=10;
        }
        return cnt;
    }
}
