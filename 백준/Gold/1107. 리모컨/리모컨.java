import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] broken;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        broken = new boolean[10];

        int t = Integer.parseInt(br.readLine());
        if(t!=0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<t; i++) {
                int num = Integer.parseInt(st.nextToken());
                broken[num]=true;
            }
        }

        int res=Math.abs(N-100);

        for(int i=0; i<=999999; i++) {
            int len = isPossible(i);
            if(len>0) {
                int answer = len+Math.abs(N-i);
                res=Math.min(answer, res);
            }
        }
        System.out.println(res);
    }

    static int isPossible(int n) {
        if(n==0) {
            return broken[0]?-1:1;
        }

        int len=0;
        while(n>0) {
            if(broken[n%10]) return -1;
            n/=10;
            len++;
        }

        return len;
    }
}
