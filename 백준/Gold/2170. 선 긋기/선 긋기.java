import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[0], b[0]));

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{start, end});
        }

        int answer = 0;
        int[] current = pq.poll();
        while(!pq.isEmpty()){
            int[] next = pq.poll();

            if(next[0]<=current[1]){
                current[1] = Math.max(current[1], next[1]);
            } else {
                answer += current[1]-current[0];
                current = next;
            }
        }

        answer += current[1]-current[0];

        System.out.println(answer);
    }
}