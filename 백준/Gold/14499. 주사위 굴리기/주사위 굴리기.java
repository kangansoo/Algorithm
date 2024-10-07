import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X, Y, K;
    static int[][] map, deltas = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static int[] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dice = new int[7];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int comm=Integer.parseInt(st.nextToken())-1;
            simulation(comm);
        }
    }

    static void simulation(int dir){
        int nx = X+deltas[dir][0];
        int ny = Y+deltas[dir][1];

        if(nx<0 || nx>=N || ny<0 || ny>=M) return;
        int tmp = dice[1];
        switch(dir){
            case 0:
                dice[1]=dice[3];
                dice[3]=dice[6];
                dice[6]=dice[4];
                dice[4]=tmp;
                break;
            case 1:
                dice[1]=dice[4];
                dice[4]=dice[6];
                dice[6]=dice[3];
                dice[3]=tmp;
                break;
            case 2:
                dice[1]=dice[2];
                dice[2]=dice[6];
                dice[6]=dice[5];
                dice[5]=tmp;
                break;
            case 3:
                dice[1]=dice[5];
                dice[5]=dice[6];
                dice[6]=dice[2];
                dice[2]=tmp;
                break;
        }
        X=nx;
        Y=ny;

        System.out.println(dice[1]);

        if(map[X][Y] == 0) {
            map[X][Y] = dice[6];
        } else {
            dice[6] = map[X][Y];
            map[X][Y] = 0;
        }
    }
}