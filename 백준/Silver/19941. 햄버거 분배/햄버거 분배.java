import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] li = br.readLine().toCharArray();;
        boolean[] visited = new boolean[N];
        int cnt=0;

        for(int i=0; i<N; i++){
            if(li[i]=='H'){
                int start = Math.max(0, i-K);
                int end = Math.min(N-1, i+K);
                for(int j=start; j<=end; j++){
                    if(!visited[j] && li[j]=='P'){
                        cnt++;
                        visited[j]=true;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}