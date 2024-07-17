import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [][] graph = new int[100][100];
		
		int N = Integer.parseInt(br.readLine());
		
		int sum=0;
		
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for(int x=a; x<a+10; x++) {
				for(int y=b; y<b+10; y++) {
					graph[x][y]=1;
				}
			}
		}
		
		for(int x=0; x<100; x++) {
			for(int y=0; y<100; y++) {
				if(graph[x][y]==1) {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}
}