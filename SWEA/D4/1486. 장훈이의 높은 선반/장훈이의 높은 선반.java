import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, B, answer;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
        	sb.append("#").append(t).append(" ");
        	StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;
            
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            
            comb(0, 0);
            sb.append(answer-B).append("\n");
        }
        System.out.println(sb);
	}
	
	private static void comb(int cnt, int sum) {
		if(cnt==N) {
			if(sum>=B) {
				if(sum<answer) answer=sum;
			}
			return;
		}
		comb(cnt+1, sum);
		comb(cnt+1, sum+arr[cnt]);
	}
}