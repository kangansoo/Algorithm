import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(dp(N));
	}

	static int dp(int n) {
		int[] d = new int[n+1];
		d[1] = 0;
		for(int i=2; i<=n; i++) {
			d[i] = d[i-1]+1;
			if(i%2==0) {
				d[i] = Math.min(d[i], d[i/2]+1);
			}
			if(i%3==0) {
				d[i] = Math.min(d[i], d[i/3]+1);
			}
		}
		return d[n];
	}
}
