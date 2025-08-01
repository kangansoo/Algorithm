import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] deltas={{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[101][101];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            dragonCurve(y, x, d, g);
        }

        System.out.println(find());
    }

    static void dragonCurve(int y, int x, int d, int g) {
        ArrayList<Integer> directions = new ArrayList<>();
        directions.add(d);

        for(int j=0; j<g; j++) {
            int size = directions.size();
            for(int i=size-1; i>=0; i--) {
                directions.add((directions.get(i)+1)%4);
            }
        }
        int cx = x;
        int cy = y;
        visited[cy][cx]=true;

        for(int dir:directions) {
            cy+=deltas[dir][0];
            cx+=deltas[dir][1];
            visited[cy][cx]=true;
        }
    }

    static int find() {
        int num=0;
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                if(visited[i][j]) {
                    if(visited[i+1][j] && visited[i][j+1] && visited[i+1][j+1]) num+=1;
                }
            }
        }
        return num;
    }
}
