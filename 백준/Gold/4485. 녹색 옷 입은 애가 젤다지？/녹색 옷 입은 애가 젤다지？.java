import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map, deltas= {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int idx=1;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			sb.append("Problem").append(" ").append(idx++).append(": ").append(minDistance(0, 0, N-1, N-1)).append("\n");
		}
		System.out.println(sb);
	}

	static int minDistance(int sr, int sc, int er, int ec) {
		final int INF = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[N][N];
		int[][] minThief = new int[N][N];
		PriorityQueue<int[]> pQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				minThief[i][j]=INF;
			}
		}
		
		minThief[sr][sc] = map[sr][sc];
		pQueue.offer(new int[] {sr, sc, minThief[sr][sc]});
		
		while(!pQueue.isEmpty()) {
			int[] stopOver = pQueue.poll();
			int r = stopOver[0];
			int c = stopOver[1];
			int money = stopOver[2];
			
			if(visited[r][c]) continue;
			visited[r][c] = true;
			if(r==er && c==ec) return money;
			
			for(int d=0; d<4; d++) {
				int nr = r+deltas[d][0];
				int nc = c+deltas[d][1];
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && minThief[nr][nc]>money+map[nr][nc]) {
					minThief[nr][nc] = money+map[nr][nc];
					pQueue.offer(new int[] {nr, nc, minThief[nr][nc]});
				}
			}
		}
		return -1;
	}
}
