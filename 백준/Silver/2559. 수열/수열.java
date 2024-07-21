import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        int[] prefixSum = new int[K+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            arr[i]=Integer.parseInt(st.nextToken());
            prefixSum[i+1]=prefixSum[i]+arr[i];
        }

        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<=K-N; i++){
            int sum = prefixSum[i+N] - prefixSum[i];
            if(sum>maxSum) maxSum =sum;
        }

        System.out.println(maxSum);
    }
}