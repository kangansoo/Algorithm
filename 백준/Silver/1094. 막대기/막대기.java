

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int cnt=0;
        int stick = 64;

        while(X>0) {
            if(stick<=X) {
                X-=stick;
                cnt++;
            }
            stick/=2;
        }

        System.out.println(cnt);

    }
}
