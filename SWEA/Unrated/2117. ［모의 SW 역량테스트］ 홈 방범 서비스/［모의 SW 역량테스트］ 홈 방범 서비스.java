import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M, maxValue;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			maxValue = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					search(i, j);
				}
			}
			sb.append("#").append(t).append(" ").append(maxValue).append("\n");
		}
		System.out.println(sb);
	}
	
	static void search(int x, int y) {
        for(int k = 1; k <= N + 1; k++) {
            int cnt = 0;
            for(int p=0; p<N; p++) {
            	for(int q=0; q<N; q++) {
            		if(Math.abs(x-p)+Math.abs(y-q)<k && map[p][q]==1) {
            			cnt++;
            		}
            	}
            }
            
//            for(int i = x - k + 1; i <= x + k - 1; i++) {
//                if(i < 0 || i >= N) continue;
//                
//                int j1 = y - (k - 1 - Math.abs(x - i));
//                int j2 = y + (k - 1 - Math.abs(x - i));
//                
//                if(j1 >= 0 && j1 < N && map[i][j1] == 1) cnt++;
//                if(j2 >= 0 && j2 < N && j1 != j2 && map[i][j2] == 1) cnt++;
//            }
            int cost = k * k + (k - 1) * (k - 1);
            int profit = cnt * M - cost;
            if(profit >= 0 && cnt > maxValue) {
                maxValue = cnt;
            }
        }
    }
}
