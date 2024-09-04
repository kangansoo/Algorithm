import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N, K, cnt, maxCnt;
	static int[][] map, highest = {{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},
					deltas= {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static boolean[][] visited;
	static boolean isDig;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int[] h:highest) {
				Arrays.fill(h, -1);
			}
			int high=0;
			int hCnt=0;
			maxCnt=Integer.MIN_VALUE;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]>high) high = map[i][j];
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==high) {
						highest[hCnt][0]=i;
						highest[hCnt++][1]=j;
					}
				}
			}
			
			for(int i=0; i<hCnt; i++) {
				visited = new boolean[N][N];
				isDig=false;
				cnt=0;
				dfs(highest[i][0], highest[i][1]);
			}
			sb.append("#").append(t).append(" ").append(maxCnt).append("\n");
		}
		
		
		System.out.println(sb);
	}

	static void dfs(int x, int y) {
	    visited[x][y] = true;
	    cnt++;
	    
	    for (int d = 0; d < 4; d++) {
	        int nx = x + deltas[d][0];
	        int ny = y + deltas[d][1];
	        
	        if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
	        
	        if (map[nx][ny] < map[x][y]) {
	            dfs(nx, ny);
	        } else if (!isDig && map[nx][ny] - map[x][y] + 1 <= K) {
	            int originalHeight = map[nx][ny];
	            map[nx][ny] = map[x][y] - 1;
	            isDig = true;
	            dfs(nx, ny);
	            map[nx][ny] = originalHeight;
	            isDig = false;
	        }
	    }
	    
	    if (cnt > maxCnt) maxCnt = cnt;
	    cnt--;
	    visited[x][y] = false;
	}

}
