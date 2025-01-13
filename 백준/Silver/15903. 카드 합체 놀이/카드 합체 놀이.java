import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            pq.add(Long.parseLong(st.nextToken()));
        }

        for(int i=0; i<M; i++){
            long a = pq.poll();
            long b = pq.poll();
            long sum = a+b;
            pq.add(sum);
            pq.add(sum);
        }

        long answer = 0;
        while(!pq.isEmpty()){
            answer+=pq.poll();
        }

        System.out.println(answer);

    }
}