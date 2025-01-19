import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        List<String> li = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String extension = st.nextToken();
            if(map.containsKey(extension)){
                map.put(extension, map.get(extension)+1);
            } else {
                map.put(extension, 1);
                li.add(extension);
            }
        }

        Collections.sort(li);

        for(String str:li){
            System.out.print(str+" ");
            System.out.println(map.get(str));
        }

    }
}