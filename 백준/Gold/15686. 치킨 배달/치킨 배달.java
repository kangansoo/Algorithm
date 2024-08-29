import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, hCnt, cCnt, answer;
	static int[][] map, home, chicken, selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		hCnt=0; cCnt=0; answer=Integer.MAX_VALUE;
		map= new int[N][N];
		home = new int[2*N][2];
		chicken = new int[13][2];
		selected = new int[M][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					home[hCnt][0]=i;
					home[hCnt++][1]=j;
				}
				else if(map[i][j]==2) {
					chicken[cCnt][0]=i;
					chicken[cCnt++][1]=j;
				}
			}
		}
		backtracking(0, 0);
		System.out.println(answer);
	}

	static void backtracking(int cnt, int start) {
		if(cnt==M) {
			int temp=0;
			for(int i=0; i<hCnt; i++) {
				int minV = Integer.MAX_VALUE;
				for(int j=0; j<M; j++) {
					int a = Math.abs(home[i][0]-selected[j][0])+Math.abs(home[i][1]-selected[j][1]);
					if(a<minV) minV=a;
				}
				temp+=minV;
			}
			if(temp<answer) answer=temp;
			return;
		}
		
		
		for(int i=start; i<cCnt; i++) {
			selected[cnt][0]=chicken[i][0];
			selected[cnt][1]=chicken[i][1];
			backtracking(cnt+1, i+1);
		}
	}
	
}
