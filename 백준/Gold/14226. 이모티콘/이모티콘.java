

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());

        int answer = bfs(S);

        System.out.println(answer);

    }

    static int bfs(int S) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1, 0, 0});
        visited = new boolean[1001][1001];
        visited[1][0]=true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int screen = curr[0];
            int clip = curr[1];
            int time = curr[2];

            if(screen == S) return time;

            if(!visited[screen][screen]) {
                visited[screen][screen] = true;
                q.add(new int[]{screen, screen, time+1});
            }

            if(clip>0 && screen+clip<=1000 && !visited[screen+clip][clip]) {
                visited[screen+clip][clip]=true;
                q.add(new int[] {screen+clip, clip, time+1});
            }

            if(screen>1 && !visited[screen-1][clip]) {
                visited[screen-1][clip]=true;
                q.add(new int[] {screen-1, clip, time+1});
            }
        }

        return -1;
    }
}
