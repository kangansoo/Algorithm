import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, cnt, node, maxValue;
	static int[][] arr, deltas= {{0, 1}, {1,0}, {0,-1}, {-1,0}};
	static boolean visited[][];
	
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			node=0;
			maxValue=Integer.MIN_VALUE;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					bfs(i, j);
				}
			}
			sb.append("#").append(t).append(" ").append(node).append(" ").append(maxValue).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
		cnt=0;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		visited = new boolean[N][N];
		visited[x][y] = true;
		while(!q.isEmpty()) {
			cnt++;
			Node curr = q.poll();
			for(int d=0; d<4; d++) {
				int nx = curr.x + deltas[d][0];
				int ny = curr.y + deltas[d][1];

				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(visited[nx][ny]) continue;
				if(arr[nx][ny]-arr[curr.x][curr.y]==1) {
					visited[nx][ny]=true;
					q.add(new Node(nx, ny));
				}
			}
		}
		if(cnt > maxValue || (cnt == maxValue && arr[x][y] < node)) {
			maxValue=cnt;
			node = arr[x][y];
		}
	}
}