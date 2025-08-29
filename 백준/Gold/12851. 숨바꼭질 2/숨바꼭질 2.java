import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int MAX=100001;
    static int N, K;
    static int[] times = new int[MAX];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(times, -1);

        bfs();
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        times[N]=0;
        int minTime = Integer.MAX_VALUE;
        int ways=0;

        while(!q.isEmpty()) {
            int curr = q.poll();

            if(times[curr]>minTime) break;

            if(curr==K) {
                if(times[curr]<minTime) {
                    minTime = times[curr];
                    ways=1;
                } else if(times[curr]==minTime) {
                    ways++;
                }
            }

            int[] nexts = {curr-1, curr+1, curr*2};

            for(int next:nexts) {
                if(next>=0 && next<MAX) {
                    if(times[next]==-1 || times[next]==times[curr]+1) {
                        times[next] = times[curr]+1;
                        q.add(next);
                    }
                }
            }
        }

        System.out.println(minTime);
        System.out.println(ways);
    }
}
