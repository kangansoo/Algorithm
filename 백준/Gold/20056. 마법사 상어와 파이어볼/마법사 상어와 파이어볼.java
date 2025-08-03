import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] deltas = {{-1,  0}, {-1,  1}, { 0,  1}, { 1,  1}, { 1,  0}, { 1, -1}, { 0, -1}, {-1, -1}};
    static List<FireBall> list;
    static List<FireBall>[][] map;
    static class FireBall {
        int r;
        int c;
        int m;
        int s;
        int d;
        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new FireBall(r, c, m, s, d));
        }

        for(int t=0; t<K; t++) {
            move();
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(map[i][j].size()>1) {
                        sumFireBall(i, j, map[i][j]);
                    }
                }
            }
            initList();
        }

        System.out.println(countFireBall());
    }

    static void initList() {
        list = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(!map[i][j].isEmpty()) {
                    for(FireBall fireBall:map[i][j]) {
                        list.add(fireBall);
                    }
                }
            }
        }
    }

    static void move() {
        map = new ArrayList[N+1][N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for(FireBall fireBall:list) {
            int nx = (fireBall.r+deltas[fireBall.d][0]*(fireBall.s%N)+N)%N;
            int ny = (fireBall.c+deltas[fireBall.d][1]*(fireBall.s%N)+N)%N;

            if(nx==0) nx=N;
            if(ny==0) ny=N;

            fireBall.r = nx;
            fireBall.c = ny;

            map[nx][ny].add(fireBall);
        }
    }

    static void sumFireBall(int x, int y, List<FireBall> fireBalls) {
        int mSum=0;
        int sSum=0;
        boolean allEven = true;
        boolean allOdd = true;
        int cnt=0;

        for(FireBall fireBall:fireBalls) {
            cnt++;
            mSum+=fireBall.m;
            sSum+=fireBall.s;
            if (fireBall.d % 2 == 0) allOdd = false;
            else allEven = false;
        }

        map[x][y] = new ArrayList<>();
        int newM = mSum/5;
        if(newM==0) return;
        int[] dirs = (allEven || allOdd) ? new int[]{0,2,4,6} : new int[]{1,3,5,7};
        for(int dir:dirs) {
            map[x][y].add(new FireBall(x, y, newM, sSum/cnt, dir));
        }
    }

    static int countFireBall() {
        int sum=0;

        for(FireBall fireBall:list) {
            sum+=fireBall.m;
        }

        return sum;
    }
}
