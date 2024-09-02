import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// dfs로 순회하며 주어진 공간 카운트
public class Main {
	
	static int N, M, K, aCnt, cnt; // 주어진 변수 값들과 공간 개수(aCnt), 각 공간의 크기(cnt) 변수
	static int[][] map, deltas= {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 4방 탐색
	static boolean[][] visited; // 방문 여부 확인 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<K; i++) { // c, d 값들은 배열 크기를 초과하므로 -1
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;
			
			for(int p=a; p<=c; p++) {
				for(int q=b; q<=d; q++) {
					map[q][p]=1; // 얼어붙은 여행지는 map에서 1로 처리
				}
			}
			
		}
		
		int[] answer = new int[N*M]; // 각 공간의 크기 배열
		int idx=0; // 공간의 크기 배열 인덱스
		
		for(int i=0; i<N; i++) { // map 순회하며 dfs 실행
			for(int j=0; j<M; j++) {
				if(map[i][j]==0 && !visited[i][j]) {
					aCnt+=1; // 순회를 시작한다면 공간의 개수 카운트
					cnt=0; // 각 공간의 크기 0으로 초기화
					answer[idx++] = dfs(i, j); // answer 배열에 각 공간의 크기 추가
				}
			}
		}
		Arrays.sort(answer);
		
		System.out.println(aCnt);
		for(int a:answer) {
			if(a!=0) {
				System.out.print(a+" ");
			}
				
		}
		
		
	}
	
	static int dfs(int x, int y) { // dfs 수행 후 cnt 반환
		cnt+=1; // 공간의 크기 카운트
		visited[x][y] = true;
		for(int d=0; d<4; d++) {
			int nx = x+deltas[d][0];
			int ny = y+deltas[d][1];
			if(nx<0 || nx >= N || ny<0 || ny>=M) continue;
			if(map[nx][ny]==0 && !visited[nx][ny]) {
				dfs(nx, ny);
			}
		}
		return cnt;
	}

}
