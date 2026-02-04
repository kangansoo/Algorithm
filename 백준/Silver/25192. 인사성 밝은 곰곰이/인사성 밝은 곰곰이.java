

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        int result=0;

        for(int i=0; i<N; i++) {
            String str = br.readLine();

            if(str.equals("ENTER")) {
                result+=set.size();
                set.clear();
            } else {
                set.add(str);
            }
        }

        result+=set.size();

        System.out.println(result);
    }
}
