import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        List<Integer> li = new ArrayList<>(K-N+1);

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<K-N+1; i++){
            int sum=0;
            for(int n=i; n<i+N; n++){
                sum+=arr[n];
            }
            li.add(sum);
        }
        System.out.println(Collections.max(li));
    }
}