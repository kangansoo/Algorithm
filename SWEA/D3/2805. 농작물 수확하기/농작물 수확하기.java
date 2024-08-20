import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int sum=0;
			
			if (N==1) {
				sum=Integer.parseInt(br.readLine());
			}else {
				int[][] arr= new int[N][N];
				int[][] deltas = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
				boolean[][] visited = new boolean[N][N];
				int dir = 0;
				int cnt=0;
				int x=0; int y=N/2;
				int k=N; int m=0;
				
				for(int i=0; i<N; i++) {
					String str = br.readLine();
					for(int j=0; j<N; j++) {
						arr[i][j]=(int)str.charAt(j)-48;
					}
				}
				
				while(cnt!=N*N/2+1) {
					visited[x][y]=true;
					sum+=arr[x][y];
					cnt++;
					
					int nx = x + deltas[dir][0];
					int ny = y + deltas[dir][1];
					
					if(nx<m || nx>=k || ny<m || ny>=k) {
						dir = (dir+1)%4;
						nx = x + deltas[dir][0];
						ny = y + deltas[dir][1];
					}
					
					if(visited[nx][ny]) {
						nx=x; 
						ny=y+1;
						dir = (dir+1)%4;
						k -= 1;
						m += 1;
					}
					
					x=nx;
					y=ny;
				}
			}
			
			System.out.println(String.format("#%d %d", t, sum));
		}
	}
	

}