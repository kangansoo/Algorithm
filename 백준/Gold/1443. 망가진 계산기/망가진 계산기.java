

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int D, P;
    static long max=-1, limit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        limit = (long)Math.pow(10, D);

        dfs(0, 1, 9);

        System.out.println(max);
    }

    static void dfs(int depth, long num, int start) {
        if(num>=limit) return;
        if(depth==P) {
            max = Math.max(num, max);
            return;
        }

        for(int i=start; i>1; i--) {
            long next = num*i;
            if(next<limit) dfs(depth+1, next, i);
        }
    }
}
