
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] nums = new int[N];
            for(int i=0; i<N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(nums);

            int cnt=0;
            int minDiff = Integer.MAX_VALUE;

            for(int i=0; i<N; i++) {
                int left = i+1;
                int right = N-1;

                while(left<=right) {
                    int mid = (left+right)/2;
                    int sum = nums[i]+nums[mid];
                    int curr = Math.abs(K-sum);

                    if(curr<minDiff) {
                        minDiff = curr;
                        cnt=1;
                    } else if(curr==minDiff) {
                        cnt++;
                    }

                    if(sum<K) left = mid+1;
                    else right = mid-1;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
