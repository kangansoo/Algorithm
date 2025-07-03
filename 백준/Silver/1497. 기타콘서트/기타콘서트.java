import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visited;
    static long[] play;
    static int answer;
    static int maxSongs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        play = new long[N];
        answer = -1;
        maxSongs = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String str = st.nextToken();
            long mask = 0L;
            for(int j=0; j<M; j++){
                if(str.charAt(j)=='Y'){
                    mask |= (1L<<j);
                }
            }
            play[i]=mask;
        }

        subSet(0);

        System.out.println(answer);
    }

    static void subSet(int cnt){
        if(cnt==N){
            countSongs();
            return;
        }
        visited[cnt]=true;
        subSet(cnt+1);
        visited[cnt]=false;
        subSet(cnt+1);
    }

    static void countSongs(){
        int cnt=0;
        long mask = 0L;

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                mask |= play[i];
                cnt++;
            }
        }

        int songCnt = Long.bitCount(mask);

        if(songCnt==0) return;

        if(songCnt>maxSongs){
            maxSongs = songCnt;
            answer = cnt;
        } else if(songCnt==maxSongs){
            answer = Math.min(answer, cnt);
        }
    }
}
