import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] numbers;
	static int N, M;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		comb(0, 1);
		System.out.println(sb.toString());
	}
	
	public static void comb(int cnt, int start) {
		if(cnt==M) {
			for(int n:numbers) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<=N; i++) {
			numbers[cnt]=i;
			comb(cnt+1, i+1);
		}
	}
}