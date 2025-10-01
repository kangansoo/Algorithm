import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for(int i=0; i<N; i++) {
            sushi[i]=Integer.parseInt(br.readLine());
        }

        for(int i=0; i<k; i++) {
            map.put(sushi[i], map.getOrDefault(sushi[i], 0)+1);
        }
        int answer = map.size();
        if(!map.containsKey(c)) answer++;

        for(int i=1; i<N; i++) {
            int left = sushi[i-1];
            map.put(left, map.get(left)-1);
            if(map.get(left)==0) map.remove(left);

            int right = sushi[(i+k-1)%N];
            map.put(right, map.getOrDefault(right, 0)+1);

            int tmp = map.size();
            if(!map.containsKey(c)) tmp++;

            answer = Math.max(answer, tmp);
        }

        System.out.println(answer);
    }
}
