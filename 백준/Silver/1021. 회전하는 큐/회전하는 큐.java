import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt;
    static int[] arr;
    static Deque<Integer> dq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;

        arr = new int[M];
        dq = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            dq.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            int target = arr[i];
            while(dq.peekFirst() != target){
                if(isLeft(target)){
                    dq.addLast(dq.pollFirst());
                    cnt++;
                } else {
                    dq.addFirst(dq.pollLast());
                    cnt++;
                }
            }
            dq.pollFirst();
        }

        System.out.println(cnt);
    }

    static boolean isLeft(int num){
        int size = dq.size();
        int idx = 0;

        for(int n:dq){
            if(n==num) break;
            idx++;
        }

        return idx<=size/2;
    }
}
