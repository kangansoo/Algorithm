import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] isSelected;
    static long[] factorial;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        factorial = new long[N+1];
        factorial[0]=1;
        for(int i=1; i<=N; i++){
            factorial[i]=factorial[i-1]*i;
        }
        isSelected = new boolean[N+1];

        st = new StringTokenizer(br.readLine());

        int type = Integer.parseInt(st.nextToken());

        if(type==1){
            long k = Long.parseLong(st.nextToken());

            for(int i=0; i<N; i++){
                for(int j=1; j<=N; j++){
                    if(isSelected[j]) continue;
                    long tmp = factorial[N-1-i];
                    if(k>tmp){
                        k-=tmp;
                    } else {
                        isSelected[j]=true;
                        sb.append(j).append(" ");
                        break;
                    }
                }
            }
        } else {
            int[] target = new int[N];
            long answer=1;
            for(int i=0; i<N; i++){
                target[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<N; i++){
                int tmp = target[i];
                int cnt = 0;
                for(int j=1;j<tmp; j++){
                    if(!isSelected[j]) cnt++;
                }
                isSelected[tmp]=true;
                answer += cnt*factorial[N-1-i];
            }
            sb.append(answer);
        }

        System.out.println(sb);
    }
}
