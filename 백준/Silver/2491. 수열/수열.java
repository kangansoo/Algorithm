import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> plus = new ArrayList<>(N);
        List<Integer> minus = new ArrayList<>(N);
        for(int i=0; i<N; i++){
            plus.add(1);
            minus.add(1);
        }

        for(int i=0; i<N-1; i++){
            if(arr[i]>=arr[i+1]){
                plus.set(i + 1, plus.get(i) + 1);
            }
        }
        for(int i=0; i<N-1; i++){
            if(arr[i]<=arr[i+1]){
                minus.set(i + 1, minus.get(i) + 1);
            }
        }

        if(Collections.max(plus)>Collections.max(minus)){
            System.out.println(Collections.max(plus));
        }else{
            System.out.println(Collections.max(minus));
        }
    }
}