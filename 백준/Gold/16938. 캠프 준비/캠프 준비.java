

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R, X, answer=0;
    static int[] numbers;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0, Integer.MAX_VALUE, 0);

        System.out.println(answer);
    }

    static void dfs(int idx, int cnt, int sum, int min, int max) {
        if(idx==N) {
            if(cnt<2) return;
            if(sum<L || sum>R) return;
            if(max-min<X) return;
            answer+=1;
            return;
        }

        dfs(idx+1, cnt+1, sum+numbers[idx], Math.min(min, numbers[idx]), Math.max(max, numbers[idx]));
        dfs(idx+1, cnt, sum, min, max);
    }
}
