import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, answer, max = 100000;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K);
            return;
        }
        
        visited = new boolean[max+1];
        answer = Integer.MAX_VALUE;
        bfs(N);
        System.out.println(answer);
	}
	
	static void bfs(int N) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {N, 0});
		visited[N]=true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int now = curr[0];
			int time = curr[1];
            visited[now] = true;
            
			if(now==K) {
				answer = Math.min(answer, time);				
			}
			int nx = now*2;
			if(nx<=max && !visited[nx]) {
				q.add(new int[] {nx, time});
			}
			int up = now + 1;
			if(up<=max && !visited[up]) {
				q.add(new int[] {up, time+1});
			}
			int down = now -1;
			if(down>=0 && !visited[down]) {
				q.add(new int[] {down, time+1});
			}
		}
	}

}