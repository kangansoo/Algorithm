

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, answer=0;
    static int[][] map, deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];


        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    static void dfs(int depth, int num) {
        answer = Math.max(num, answer);
        if(depth==3) return;

        boolean[][] visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]==0 || visited[i][j]) continue;
                List<int[]> broken = bfs(i, j, visited);

                int[][] backup = copy(map);
                remove(broken);
                fallDown();
                dfs(depth+1, num+broken.size()*broken.size());
                map=backup;
            }
        }
    }

    static List<int[]> bfs(int x, int y, boolean[][] visited) {
        List<int[]> list = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int n = map[x][y];
        visited[x][y]=true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            list.add(cur);

            for(int d=0; d<4; d++) {
                int nx = cur[0]+deltas[d][0];
                int ny = cur[1]+deltas[d][1];

                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && map[nx][ny]==n) {
                    visited[nx][ny]=true;
                    q.add(new int[]{nx, ny});
                }
            }

        }

        return list;
    }

    static void fallDown() {
        for(int j=0; j<M; j++) {
            int idx = N-1;
            for(int i=N-1; i>=0; i--) {
                if(map[i][j]==0) continue;
                int tmp = map[i][j];
                map[i][j]=0;
                map[idx--][j]=tmp;
            }
        }
    }

    static int[][] copy(int[][] origin) {
        int[][] copied = new int[N][M];
        for(int i=0; i<N; i++) copied[i] = origin[i].clone();
        return copied;
    }

    static void remove(List<int[]> broken) {
        for(int[] b:broken) {
            map[b[0]][b[1]]=0;
        }
    }
}
