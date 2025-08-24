import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N, K;
    static Set<String> set;
    static int[] numbers;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        set = new HashSet<>();

        numbers = new int[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            numbers[i]=Integer.parseInt(br.readLine());
        }

        dfs(0, "");

        System.out.println(set.size());
    }

    static void dfs(int depth, String num) {
        if(depth>K) {
            return;
        }
        if(depth==K) {
            set.add(num);
        }
        for(int i=0; i<N; i++) {
            if(visited[i]) continue;
            visited[i]=true;
            dfs(depth+1, num+numbers[i]);
            visited[i]=false;
        }
    }
}
