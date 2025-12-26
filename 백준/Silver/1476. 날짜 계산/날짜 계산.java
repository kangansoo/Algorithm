

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt=0;
        while(E!=0 && S!=0 && M!=0) {
            E-=1;
            S-=1;
            M-=1;
            cnt+=1;
            if(E==0 && (S!=0 || M!=0)) E=15;
            if(S == 0 && E != 0) S=28;
            if(M == 0 && E != 0) M=19;
        }
        System.out.println(cnt);
    }
}
