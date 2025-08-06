import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=T; t++) {
            int ans=0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            HashSet<String> set = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                set.add(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                set.add(st.nextToken());
            }

            sb.append("#").append(t).append(" ").append(N+M-set.size()).append("\n");
        }

        System.out.println(sb);
    }
}
