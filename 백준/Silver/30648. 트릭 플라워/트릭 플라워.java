import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(br.readLine());
        int cnt=0;

        boolean[][] visited = new boolean[r][r];

        while(true){
            if(visited[a][b]){
                System.out.println(cnt);
                return;
            }
            cnt++;
            visited[a][b]=true;
            if(a+b+2<r){
                a+=1;
                b+=1;
            } else {
                a/=2;
                b/=2;
            }
        }

    }
}