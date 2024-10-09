import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, K;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    static Node[][] nodes;

    static class Node {
        int dir;
        int size;

        public Node(int dir, int size) {
            this.dir = dir;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            nodes = new Node[N][N];

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int size = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                nodes[i][j] = new Node(dir, size);
            }

            for (int m = 0; m < M; m++) {
                move();
            }

            long result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (nodes[i][j] != null) {
                        result += nodes[i][j].size;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    static void move() {
        Node[][] mNodes = new Node[N][N];
        int[][] sizeSum = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (nodes[i][j] != null) {
                    Node cur = nodes[i][j];
                    int nx = i + dx[cur.dir];
                    int ny = j + dy[cur.dir];

                    if (nx <= 0 || ny <= 0 || nx >= N - 1 || ny >= N - 1) {
                        cur.size /= 2;
                        if (cur.size == 0) continue;
                        cur.dir = changeDir(cur.dir);
                    }

                    if (mNodes[nx][ny] == null || mNodes[nx][ny].size < cur.size) {
                        mNodes[nx][ny] = new Node(cur.dir, cur.size);
                    }
                    sizeSum[nx][ny] += cur.size;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mNodes[i][j] != null) {
                    mNodes[i][j].size = sizeSum[i][j];
                }
            }
        }

        nodes = mNodes;
    }

    static int changeDir(int d) {
        return d % 2 == 0 ? d - 1 : d + 1;
    }
}