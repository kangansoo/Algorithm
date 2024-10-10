import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            List<int[]> stores = new ArrayList<>();
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int storeX = Integer.parseInt(st.nextToken());
                int storeY = Integer.parseInt(st.nextToken());
                stores.add(new int[]{storeX, storeY});
            }
            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            sb.append(bfs(sx, sy, stores, ex, ey)).append("\n");
        }
        System.out.println(sb);
    }

    static boolean distance(int x, int y, int i, int j){
        return Math.abs(x-i) + Math.abs(y-j) <= 1000;
    }

    static String bfs(int sx, int sy, List<int[]> stores, int ex, int ey){
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[stores.size()];
        q.add(new int[]{sx, sy});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            if(distance(cx, cy, ex, ey)) return "happy";
            for(int i=0; i<stores.size(); i++){
                if(!visited[i]){
                    int storeX = stores.get(i)[0];
                    int storeY = stores.get(i)[1];

                    if (distance(cx, cy, storeX, storeY)) {
                        visited[i] = true;
                        q.offer(new int[]{storeX, storeY});
                    }
                }
            }
        }
        return "sad";
    }
}