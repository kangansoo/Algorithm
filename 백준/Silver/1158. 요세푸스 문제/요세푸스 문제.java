import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            q.add(i);
        }

        sb.append("<");

        while(q.size()>1){
            for(int i=1; i<K; i++){
                q.add(q.poll());
            }
            sb.append(q.poll()).append(",").append(" ");
        }

        sb.append(q.poll()).append(">");

        System.out.println(sb);
    }
}
