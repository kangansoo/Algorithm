import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N, answer;
    static int[][] map, deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<Node> q = new LinkedList<>();;

    static class Node {
        int x, y, dir, energy;

        public Node(int x, int y, int dir, int energy) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.energy = energy;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        map = new int[4001][4001];

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            answer = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int y = (Integer.parseInt(st.nextToken()) << 1) + 2000;
                int x = 4000 - ((Integer.parseInt(st.nextToken()) << 1) + 2000);
                int dir = Integer.parseInt(st.nextToken());
                int energy = Integer.parseInt(st.nextToken());
                map[x][y] = energy;
                q.add(new Node(x, y, dir, energy));
            }

            move();
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void move() {
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            int dir = curr.dir;
            int energy = curr.energy;

            if (map[x][y] != energy) {
                answer += map[x][y];
                map[x][y] = 0;
                continue;
            }

            int nx = x + deltas[dir][0];
            int ny = y + deltas[dir][1];

            if (nx >= 0 && nx <= 4000 && ny >= 0 && ny <= 4000) {
                if (map[nx][ny] == 0) {
                    map[nx][ny] = energy;
                    q.add(new Node(nx, ny, dir, energy));
                } else {
                    map[nx][ny] += energy;
                }
            }
            map[x][y] = 0;
        }
    }
}