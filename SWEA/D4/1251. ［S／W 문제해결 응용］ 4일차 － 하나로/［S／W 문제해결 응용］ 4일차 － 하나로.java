import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static double E;
    static int[] parents;
    static Edge[] edges;

    static class Edge implements Comparable<Edge>{
        int start, end;
        long weight;

        public Edge(int start, int end, long weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            long[] rows = new long[N];
            long[] cols = new long[N];
            parents = new int[N];
            int eCnt = N * (N - 1) / 2;
            edges = new Edge[eCnt];
            long edge;
            int k = 0;

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                rows[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                cols[i] = Long.parseLong(st.nextToken());
            }
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    edge = (long) Math.pow(rows[i] - rows[j], 2) + (long) Math.pow(cols[i] - cols[j], 2);
                    edges[k++] = new Edge(i, j, edge);
                }
            }

            E = Double.parseDouble(br.readLine());
            Arrays.sort(edges);
            make();
            long totalCost = 0;
            int mstCnt = 0;
            for (Edge e : edges) {
                if (union(e.start, e.end)) {
                    totalCost += e.weight;
                    if (++mstCnt == N - 1) break; // Minimum spanning tree is complete
                }
            }

            sb.append("#").append(t).append(" ").append(Math.round(totalCost * E)).append("\n");
        }

        System.out.println(sb);
    }

    static void make() {
        parents = new int[N];
        Arrays.fill(parents, -1);
    }

    static int findSet(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot == bRoot) {
            return false;
        }
        parents[bRoot] = aRoot;
        return true;
    }
}