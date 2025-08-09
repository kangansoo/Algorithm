import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, D, maxValue=0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N+1][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0);

        System.out.println(maxValue);
    }

    static void comb(int depth, int start) {
        if(depth==3) {
            play();
            return;
        }
        for(int i=start; i<M; i++) {
            map[N][i]=9;
            comb(depth+1, i+1);
            map[N][i]=0;
        }
    }

    static void play() {
        int cnt=0;
        int[][] newMap=copyMap(map);
        while(!isEnd(newMap)) {
            HashSet<String> set = new HashSet<>();
            for(int i=0; i<M; i++) {
                if(newMap[N][i]==9) {
                    int[] enemy=findEnemy(newMap, N, i);
                    if(enemy!=null) {
                        set.add(enemy[0]+" "+enemy[1]);
                    }
                }
            }
            for(String tmp:set) {
                String[] xy = tmp.split(" ");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                newMap[x][y]=0;
                cnt++;
            }
            move(newMap);
        }
        maxValue = Math.max(maxValue, cnt);
    }

    static boolean isEnd(int[][] board) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j]!=0) return false;
            }
        }
        return true;
    }

    static void move(int[][] board) {
        for(int i=N-1; i>=0; i--) {
            for(int j=0; j<M; j++) {
                if(board[i][j]==1) {
                    if(i+1!=N) {
                        board[i+1][j]=1;
                    }
                    board[i][j]=0;
                }
            }
        }
    }

    static int[][] copyMap(int[][] map) {
        int[][] copiedMap = new int[N+1][M];
        for(int i=0; i<=N; i++) {
            copiedMap[i]=map[i].clone();
        }
        return copiedMap;
    }

    static int[] findEnemy(int[][] board, int x, int y) {
        List<int[]> li = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j]!=0) {
                    int dist = Math.abs(x-i)+Math.abs(y-j);
                    if(dist<=D) li.add(new int[]{i, j, dist});
                }
            }
        }
        if(li.isEmpty()) return null;
        li.sort((a, b)-> {
           if(a[2]!=b[2]) return Integer.compare(a[2], b[2]);
           return Integer.compare(a[1], b[1]);
        });
        int[] enemy = li.get(0);
        return new int[]{enemy[0], enemy[1]};
    }
}
