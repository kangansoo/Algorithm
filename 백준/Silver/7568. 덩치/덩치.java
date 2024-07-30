import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		int[] result = new int[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			int cnt=1;
			for(int j=0; j<n; j++) {
				if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]) {
					cnt++;
				}
			}
			result[i]=cnt;
		}
		for(int a:result) {
			System.out.print(a+" ");
		}
	}
}