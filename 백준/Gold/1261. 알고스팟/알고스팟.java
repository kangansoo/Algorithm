import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int N, M;
	static int[][] dist, deltas= {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static char[][] map;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        dist = new int[N][M];
        for(int i=0; i<N; i++) {
        	String str = br.readLine();
        	map[i]=str.toCharArray();
        	Arrays.fill(dist[i], INF);
        }
        
        dijkstra();
        
        System.out.println(dist[N-1][M-1]);
	}

	static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[2], b[2]));
		pq.add(new int[] {0, 0, map[0][0]-'0'});
		dist[0][0]=0;
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			int x = curr[0];
			int y = curr[1];
			int wall = curr[2];
			
			for(int d=0; d<4; d++) {
				int nx = x+deltas[d][0];
				int ny = y+deltas[d][1];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					int nWall = wall + (map[nx][ny]-'0');
					if(dist[nx][ny]>nWall) {
						dist[nx][ny]=nWall;
						pq.add(new int[] {nx, ny, nWall});
					}
				}
			}
		}
	}
}