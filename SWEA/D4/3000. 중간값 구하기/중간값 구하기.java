import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int value = 20171109;

        for(int t=1; t<=T; t++){
            PriorityQueue<Integer> minH = new PriorityQueue<>();
            PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            minH.add(v);
            int answer=0;

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                minH.add(Math.max(a, b));
                maxH.add(Math.min(a, b));

                if(!minH.isEmpty() && !maxH.isEmpty() && minH.peek()<maxH.peek()){
                    maxH.add(minH.poll());
                    minH.add(maxH.poll());
                }
                if(!minH.isEmpty()){
                    answer= (answer+minH.peek())%value;
                }
            }

            System.out.println("#"+t+" "+answer);
        }
    }
}
