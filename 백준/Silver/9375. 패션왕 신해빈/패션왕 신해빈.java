import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int T, N;
    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            map = new HashMap<>();
            N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0)+1);
            }

            int result = 1;

            for(int cnt:map.values()){
                result *= (cnt+1);
            }

            System.out.println(result-1);
        }
    }
}
