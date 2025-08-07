import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            long N = Long.parseLong(br.readLine());
            long l = 1;
            long r = 10000000000L;
            long res=0;
            while(l<=r) {
                long mid = (l+r)/2;
                long value = mid*(mid+1)/2;

                if(N>=value) {
                    l=mid+1;
                    res=mid;
                } else {
                    r=mid-1;
                }
            }

            long value = res*(res+1)/2;
            sb.append("#").append(t).append(" ");
            if(N!=value) {
                sb.append(-1);
            } else {
                sb.append(res);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
