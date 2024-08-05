import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] deltas = {{0,1}, {0,-1}, {1, 0}, {-1, 0}};
		int[][] paper = new int[101][101];
		int cnt=0;
		
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int i=a; i<10+a; i++) {
				for(int j=b; j<10+b; j++) {
					paper[i][j]=1;
				}
			}
		}
		
		for(int x=0; x<101; x++) {
			for(int y=0; y<101; y++) {
				if(paper[x][y]==1) {
					for(int d=0; d<4; d++) {
						int nx=x+deltas[d][0];
						int ny=y+deltas[d][1];
						if(paper[nx][ny]==0) {
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}