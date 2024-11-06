import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];
        int[] line = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            line[i] = -1;
        }

        for(int i=0; i<N; i++){
            int cnt = people[i];
            for(int j=0; j<N; j++){
                if(cnt==0 && line[j]==-1) {
                    line[j] = i+1;
                    break;
                } else if(line[j]==-1) {
                    cnt--;
                }

            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(line[i]).append(" ");
        }
        System.out.println(sb);
    }
}