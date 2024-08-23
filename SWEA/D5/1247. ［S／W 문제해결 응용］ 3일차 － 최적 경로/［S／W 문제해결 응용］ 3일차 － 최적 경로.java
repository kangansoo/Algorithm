import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 순열 백트래킹
public class Solution {
	
	static int N, minValue, distance;
	static int[] home, company, next;
	static int[][] clients;
	static boolean[] selected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			
			home = new int[2]; // 집 좌표
			company = new int[2]; // 회사 좌표
			clients = new int[N][2]; // 고객들 좌표
			selected = new boolean[N]; // 선택 여부 확인 좌표
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<2; i++) {
				home[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<2; i++) {
				company[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<2; j++) {
					clients[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			minValue=Integer.MAX_VALUE; // 최소 값 초기화
			backtracking(0, 0, company); // 백트래킹 실행
			sb.append(minValue).append("\n");
		}
		System.out.println(sb);
	}
	
	// 백트래킹
	static void backtracking(int depth, int sum, int[] curr) {
		if(sum>=minValue) return; // 최단경로가 아니라면 함수 종료
		if(depth==N) { // 고객들을 다 방문한 후
			sum += Math.abs(home[0]-curr[0])+Math.abs(home[1]-curr[1]); // 집으로 가는 거리 더하기
			if(sum<minValue) minValue=sum; // 최소 값 확인
			return;
		}
		for(int i=0;i<N;i++) {
			if(selected[i]) continue;
			selected[i]=true;
			int[] next = clients[i]; // 현재위치 변경
			distance = Math.abs(curr[0]-clients[i][0])+Math.abs(curr[1]-clients[i][1]); // 거리 구하기
			backtracking(depth+1, sum+distance, next);
			selected[i]=false;
		}
	}
}