import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] primes = {2, 3, 5, 7};
        for(int p:primes) {
            dfs(0, p);
        }

        System.out.println(sb);
    }

    static void dfs(int depth, int n) {
        if(!isPrime(n)) return;
        if(isPrime(n) && depth==N-1) {
            sb.append(n).append("\n");
        }

        for(int i=1; i<=9; i++) {
            dfs(depth+1, n*10+i);
        }
    }

    static boolean isPrime(int n) {
        if(n<2) return false;
        for(int i=2; i*i<=n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}
