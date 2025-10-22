import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean isSolved;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(0, "");
    }

    static void dfs(int depth, String n) {
        if(isSolved) return;
        if(!check(n)) return;
        if(depth==N) {
            isSolved=true;
            System.out.println(n);
            return;
        }
        for(int i=1; i<=3; i++) {
            if(depth>0 && n.charAt(depth-1)-'0'==i) continue;
            dfs(depth+1, n+i);
        }
    }

    static boolean check(String n) {
        int len = n.length();

        for(int i=2; i<=len/2; i++) {
            if(n.substring(len-i).equals(n.substring(len-2*i, len-i))) return false;
        }
        return true;
    }
}
