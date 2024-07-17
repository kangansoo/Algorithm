import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws Exception {
		int [][] graph = new int[1001][1001];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int x=0; x<1001; x++) {
			for(int y=0; y<1001; y++) {
				graph[x][y]=0;
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		
		for (int n=1; n<=N; n++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			for(int x=a; x<=a+c-1; x++) {
				for(int y=b; y<=b+d-1; y++) {
					graph[x][y]=n;
				}
			}

		}
		
		for (int n=1; n<=N; n++) {

			int sum=0;
			
			for(int x=0; x<1001; x++) {
				for(int y=0; y<1001; y++) {
					if(graph[x][y]==n) {
						sum++;
					}
				}
			}
			
			System.out.println(sum);
		}
		
	}

}