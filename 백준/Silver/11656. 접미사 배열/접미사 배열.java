import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        List<String> li = new ArrayList<>();

        char[] arr = str.toCharArray();

        for(int i=0; i<str.length(); i++){
            for(int j=i; j<str.length(); j++){
                sb.append(arr[j]);
            }
            li.add(sb.toString());
            sb.setLength(0);
        }

        Collections.sort(li);

        for(String s:li){
            System.out.println(s);
        }
    }
}