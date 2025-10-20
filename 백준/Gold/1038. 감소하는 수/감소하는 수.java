import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Long> numbers = new ArrayList<>();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if(N<10) {
            System.out.println(N);
            return;
        }

        if(N>=1023) {
            System.out.println(-1);
            return;
        }

        for(int i=0; i<10; i++) {
            dfs(0, i);
        }

        Collections.sort(numbers);
        System.out.println(numbers.get(N));
    }

    static void dfs(int depth, long num) {
        if(depth==10) return;
        numbers.add(num);

        for(int i=0; i<num%10; i++) {
            dfs(depth+1, num*10+i);
        }
    }
}
