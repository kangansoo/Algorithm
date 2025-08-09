import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean flag;
    static int N, M, minValue=Integer.MAX_VALUE;
    static int[] use;
    static int[][] map, deltas={{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static boolean[][] visited;
    static List<int[]> candidate;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        candidate = new ArrayList<>();
        use = new int[M];
        flag=true;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n==1) {
                    map[i][j]=-1;
                    continue;
                }
                if(n==2) {
                    candidate.add(new int[]{i, j});
                    map[i][j]=0;
                    continue;
                }
                map[i][j] = n;
            }
        }

        comb(0, 0);

        System.out.println(!flag?minValue:-1);
    }

    static void comb(int depth, int start) {
        if(depth==M) {
            spread();
            return;
        }
        for(int i=start; i<candidate.size(); i++) {
            use[depth]=i;
            comb(depth+1, i+1);
        }
    }

    static void spread() {
        Queue<int[]> q = new LinkedList<>();
        int[][] newMap = copyMap(map);
        visited = new boolean[N][N];
        for(int i=0; i<M; i++) {
            int[] tmp = candidate.get(use[i]);
            q.add(new int[]{tmp[0], tmp[1], 1});
            visited[tmp[0]][tmp[1]] = true;
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int v = curr[2];

            newMap[x][y]=v;

            for(int d=0; d<4; d++) {
                int dx = x+deltas[d][0];
                int dy = y+deltas[d][1];

                if(dx>=0 && dx<N && dy>=0 && dy<N && newMap[dx][dy]!=-1 && !visited[dx][dy]) {
                    q.add(new int[]{dx, dy, v+1});
                    visited[dx][dy]=true;
                }
            }
        }

        check(newMap);
    }

    static int[][] copyMap(int[][] board) {
        int[][] copiedMap = new int[N][N];
        for(int i=0; i<N; i++) {
            copiedMap[i] = board[i].clone();
        }

        return copiedMap;
    }

    static void check(int[][] newMap) {
        boolean check=false;
        int cnt=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(newMap[i][j]==0) check=true;
                cnt=Math.max(newMap[i][j], cnt);
            }
        }
        if(!check) {
            flag=false;
            minValue = Math.min(minValue, cnt-1);
        }
    }
}
