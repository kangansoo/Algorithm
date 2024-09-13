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
		int[][] map = new int[N][M];
		int maxValue = 1;
		
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			int len = 0;
			int vertex;
			for(int j=0; j<M-1; j++) {
				vertex = map[i][j];
				for(int y=j+1; y<M; y++) {
					if(map[i][y]==vertex) {
						len = y-j;  
						if(i+len<N && map[i+len][j] == vertex && map[i+len][y] == vertex) {
							maxValue = Math.max(maxValue, (len+1)*(len+1));
						}
					}
				}
			}
			
		}
		
		System.out.println(maxValue);
		
		
	}

}
