import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, answer, max = 100001;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[max];
        answer = 0;
        
        if(N>=K) {
        	System.out.println(N-K);
        	return;
        }
        bfs(N);
        System.out.println(answer);
	}

	static void bfs(int n) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {n, 0});
		visited[n]=true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int now = curr[0];
			int time = curr[1];
			
			if(now == K) {
				answer = time;
				return;
			}
			
			int telpo = now * 2;
			if(telpo<max && !visited[telpo]) {
				visited[telpo]=true;
				q.add(new int[] {telpo, time+1});
			}
			
			int up = now + 1;
			if(up<max && !visited[up]) {
				visited[up]=true;
				q.add(new int[] {up, time+1});
			}
			
			int down = now - 1;
			if(down>=0 && !visited[down]) {
				visited[down]=true;
				q.add(new int[] {down, time+1});
			}
		}
	}
	
}