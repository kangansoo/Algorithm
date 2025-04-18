import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt=0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0)+1);
        }

        for(int i=0; i<M; i++){
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0)+1);
        }

        for(int value:map.values()){
            if(value==2) cnt++;
        }
        System.out.println(cnt);

        for(String key: map.keySet()){
            if(map.get(key)==2){
                System.out.println(key);
            }
        }

    }
}
