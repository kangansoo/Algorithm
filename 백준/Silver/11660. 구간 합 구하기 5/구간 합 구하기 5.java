import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][N];
		int[][] prefix = new int[N][N];
		
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				prefix[i][j] = arr[i][j];
				if(i > 0) prefix[i][j] += prefix[i - 1][j];
				if(j > 0) prefix[i][j] += prefix[i][j-1];
				if(i > 0 && j > 0) prefix[i][j] -= prefix[i-1][j-1];
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken())-1;
			int y1 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken())-1;
			int y2 = Integer.parseInt(st.nextToken())-1;
			
			int value = prefix[x2][y2];
			if(x1>0) value -= prefix[x1-1][y2];
			if(y1>0) value -= prefix[x2][y1-1];
			if(x1>0 && y1>0) value += prefix[x1-1][y1-1];
			System.out.println(value);
		}
	}

}