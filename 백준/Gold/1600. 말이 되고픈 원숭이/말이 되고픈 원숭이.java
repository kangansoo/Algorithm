import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K, N, M, answer;
	static int[][] map, deltas= {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}, deltas2= {{-1, -2}, {-2, -1}, {-2, 1},  {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
	static boolean[][][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][K+1];
		answer=-1;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		System.out.println(answer);
		
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, 0, K});
		visited[0][0][K]=true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int x=curr[0];
			int y=curr[1];
			int cnt=curr[2];
			int k=curr[3];
			
			if(x==N-1 && y==M-1) {
				answer = cnt;
				return;
			}
			
			for(int d=0; d<4; d++) {
				int nx = x+deltas[d][0];
				int ny = y+deltas[d][1];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny][k] && map[nx][ny]!=1) {
					q.add(new int[] {nx, ny, cnt+1, k});
					visited[nx][ny][k]=true;
				}
				
			}
			
			if(k>0) {
				for(int d=0; d<8; d++) {
					int nx = x+deltas2[d][0];
					int ny = y+deltas2[d][1];
					if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny][k-1] && map[nx][ny]!=1) {
						q.add(new int[] {nx, ny, cnt+1, k-1});
						visited[nx][ny][k-1]=true;
					}
				}
			}
			
		}
	}

}