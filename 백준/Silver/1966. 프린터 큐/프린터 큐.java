import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<N; n++){
                int input = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{n, input});
            }

            int cnt=0;
            while(!queue.isEmpty()){
                int[] current = queue.poll();
                boolean isMax = true;
                for(int[] q:queue){
                    if(q[1]>current[1]){
                        isMax=false;
                        break;
                    }
                }
                if(isMax){
                    cnt++;
                    if(current[0]==M){
                        System.out.println(cnt);
                        break;
                    }
                }else{
                    queue.offer(current);
                }
            }
        }
    }
}