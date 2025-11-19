

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            List<Integer>[] list = new ArrayList[26];
            for(int i=0; i<26; i++) list[i] = new ArrayList<>();

            for(int i=0; i<str.length(); i++) {
                list[str.charAt(i)-'a'].add(i);
            }

            int min = Integer.MAX_VALUE;
            int max = -1;

            for(int i=0; i<26; i++) {
                List<Integer> li = list[i];
                if(li.size()<k) continue;

                for(int j=0; j<=li.size()-k; j++) {
                    int s = li.get(j);
                    int e = li.get(j+k-1);

                    int len = e-s+1;

                    min = Math.min(min, len);
                    max = Math.max(max, len);
                }
            }

            if(max==-1) sb.append(-1).append("\n");
            else sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
