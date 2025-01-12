import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>((a, b)-> b-a);

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++){
            rpq.add(Integer.parseInt(st.nextToken()));
        }

        int answer=0;
        while(!pq.isEmpty()){
            answer+=(pq.poll()*rpq.poll());
        }

        System.out.println(answer);

    }
}