import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, maxScore;
    static int[][] players;
    static int[] order;
    static boolean[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        players = new int[N][10];
        order = new int[10];
        selected = new boolean[10];
        maxScore = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=9; j++) {
                players[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order[4]=1;
        selected[4]=true;

        perm(2);

        System.out.println(maxScore);
    }

    static void perm(int cnt) {
        if(cnt==10) {
            playBaseBall();
            return;
        }

        for(int i=1; i<=9; i++) {
            if(selected[i]) continue;
            selected[i]=true;
            order[i]=cnt;
            perm(cnt+1);
            selected[i]=false;
        }
    }

    static void playBaseBall() {
        boolean[] base;
        int score=0;
        int currPlayer=1;

        for(int i=0; i<N; i++) {
            base = new boolean[4];
            int out=0;

            while(out<3) {
                int player = order[currPlayer];
                int curr = players[i][player];

                switch(curr) {
                    case 0:
                        out++;
                        break;
                    case 1:
                        for(int n=3; n>=1; n--) {
                            if(base[n]) {
                                if(n==3) {
                                    score++;
                                } else {
                                    base[n+1]=true;
                                }
                                base[n]=false;
                            }
                        }
                        base[1]=true;
                        break;
                    case 2:
                        for(int n=3; n>=1; n--) {
                            if(base[n]) {
                                if(n>=2) {
                                    score++;
                                } else {
                                    base[n+2]=true;
                                }
                                base[n]=false;
                            }
                        }
                        base[2]=true;
                        break;
                    case 3:
                        for(int n=3; n>=1; n--) {
                            if(base[n]) {
                                score++;
                                base[n]=false;
                            }
                        }
                        base[3]=true;
                        break;
                    case 4:
                        for(int n=3; n>=1; n--) {
                            if(base[n]) {
                                score++;
                                base[n]=false;
                            }
                        }
                        score++;
                        break;
                }
                currPlayer = currPlayer%9+1;
            }
        }
        maxScore=Math.max(maxScore, score);
    }
}
