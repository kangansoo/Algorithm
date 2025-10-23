

import java.io.*;
import java.util.*;

public class Main {
    static int N, min = Integer.MAX_VALUE;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(min);
    }

    static void dfs(int depth) {
        if (depth == N) {
            int teamA = 0, teamB = 0;
            for (boolean v : visited) {
                if (v) teamA++;
                else teamB++;
            }
            if (teamA == 0 || teamB == 0) return;

            int sumA = 0, sumB = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] && visited[j])
                        sumA += graph[i][j] + graph[j][i];
                    else if (!visited[i] && !visited[j])
                        sumB += graph[i][j] + graph[j][i];
                }
            }

            min = Math.min(min, Math.abs(sumA - sumB));
            return;
        }

        visited[depth] = true;
        dfs(depth + 1);
        visited[depth] = false;
        dfs(depth + 1);
    }
}
