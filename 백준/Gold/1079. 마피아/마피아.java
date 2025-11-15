

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, mafia, answer=0;
    static int[][] graph;
    static boolean[] dead;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] people = new int[N];
        graph = new int[N][N];
        dead = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        mafia = Integer.parseInt(br.readLine());

        dfs(0, N, people);

        System.out.println(answer);
    }

    static void dfs(int night, int cnt, int[] people) {
        if(canWin() || cnt<=1 || dead[mafia]) {
            answer = Math.max(night, answer);
            return;
        }

        if(cnt%2==0) {
            for(int i=0; i<N; i++) {
                if(i==mafia) continue;
                if(dead[i]) continue;

                dead[i]=true;

                for(int j=0; j<N; j++) {
                    if(dead[j]) continue;
                    if(i==j) continue;
                    people[j] += graph[i][j];
                }

                dfs(night+1, cnt-1, people);

                for(int j=0; j<N; j++) {
                    if(dead[j]) continue;
                    if(i==j) continue;
                    people[j] -= graph[i][j];
                }

                dead[i]=false;
            }
        } else {
            int target = -1;
            int max = Integer.MIN_VALUE;
            for(int i=0; i<N; i++) {
                if(dead[i]) continue;
                if(people[i]>max) {
                    max=people[i];
                    target=i;
                }
            }

            if(target==-1) return;

            dead[target]=true;
            dfs(night, cnt-1, people);
            dead[target]=false;
        }
    }


    static boolean canWin() {
        if(dead[mafia]) return false;
        int alive=0;
        for(int i=0; i<N; i++) {
            if(!dead[i]) alive++;
        }
        return alive==1;
    }
}
