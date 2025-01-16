import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<Integer> dq = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "push":
                    dq.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    if(dq.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.peekFirst()).append("\n");
                    }
                    break;
                case "back":
                    if(dq.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.peekLast()).append("\n");
                    }
                    break;
                case "pop":
                    if(dq.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.poll()).append("\n");
                    }
                    break;
                case "empty":
                    if(dq.isEmpty()){
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;

            }


        }

        System.out.println(sb);

    }
}