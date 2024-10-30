import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, answer = Integer.MIN_VALUE;
    static int[][] li;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        li = new int[N][2];

        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            li[i][0] = Integer.parseInt(st.nextToken());
            li[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int idx, int pay){
        if(idx>=N){
            answer = Math.max(answer, pay);
            return;
        }
        if(idx+li[idx][0]<=N){
            dfs(idx+li[idx][0], pay+li[idx][1]);
        }else{
            dfs(idx+li[idx][0], pay);
        }
        dfs(idx+1, pay);
    }
}