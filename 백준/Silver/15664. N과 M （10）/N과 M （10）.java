import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, numbers[], arr[];
    static boolean[] isSelected;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        numbers = new int[M];
        isSelected = new boolean[N];
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        perm(0, 0);
        System.out.println(sb);
    }

    private static void perm(int cnt, int start){
        if(cnt == M){
            for(int n:numbers){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        int curr = -1;
        for(int i=start; i<N; i++){
            if(isSelected[i]) continue;
            if(arr[i] == curr) continue;
            curr = arr[i];
            numbers[cnt]=arr[i];
            isSelected[i] = true;
            perm(cnt+1, i+1);
            isSelected[i] = false;
        }
    }

}