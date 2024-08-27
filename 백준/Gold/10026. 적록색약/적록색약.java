import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
    static char[][] graph;
    static boolean[][] visited;
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        graph = new char[n][n];
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j);
            }
        }
        
        int cnt = 0;
        int cnt2 = 0;
        
        // 정상적인 경우
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, graph[i][j]);
                    cnt++;
                }
            }
        }
        
        // 방문 배열 초기화
        visited = new boolean[n][n];
        
        // 적록색약인 경우 'G'를 'R'로 변환
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 'G') {
                    graph[i][j] = 'R';
                }
            }
        }
        
        // 적록색약인 경우 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, graph[i][j]);
                    cnt2++;
                }
            }
        }
        
        System.out.println(cnt + " " + cnt2);
    }
    
    static void dfs(int x, int y, char color) {
        visited[x][y] = true;
        
        for (int[] delta : deltas) {
            int nx = x + delta[0];
            int ny = y + delta[1];
            
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visited[nx][ny] && graph[nx][ny] == color) {
                    dfs(nx, ny, color);
                }
            }
        }
    }
}
