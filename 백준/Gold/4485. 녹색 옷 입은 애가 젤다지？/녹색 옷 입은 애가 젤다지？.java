import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] map, dist, deltas= {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int idx=1;
        
        while(true) {
        	N = Integer.parseInt(br.readLine());
        	if(N==0) break;
        	map = new int[N][N];
        	dist = new int[N][N];
        	visited = new boolean[N][N];
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0; j<N; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken()); 
        		}
        	}
        	
        	sb.append("Problem ").append(idx++).append(": ").append(setDist()).append("\n");
        	
        }
        System.out.println(sb);
	}

	static int setDist() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[2], b[2]));
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				dist[i][j]=INF;
			}
		}
		dist[0][0]=map[0][0];
		pq.add(new int[] {0, 0, dist[0][0]});
		visited[0][0]=true;
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			int x = curr[0];
			int y = curr[1];
			int money = curr[2];
			if(x==N-1 && y==N-1) {
				return money;
			}
			for(int d=0; d<4; d++) {
				int nx = x+deltas[d][0];
				int ny = y+deltas[d][1];
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && money+map[nx][ny]<dist[nx][ny]) {
					dist[nx][ny]=money+map[nx][ny];
					visited[nx][ny]=true;
					pq.add(new int[] {nx, ny, dist[nx][ny]});
				}
			}
			
		}
		
		return -1;
	}
}