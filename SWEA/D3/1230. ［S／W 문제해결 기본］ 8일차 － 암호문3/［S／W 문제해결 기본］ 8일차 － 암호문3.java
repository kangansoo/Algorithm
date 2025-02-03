import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    static int N, M;
    static StringBuilder sb;
    static LinkedList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        for(int t=1; t<=10; t++){
            list = new LinkedList<>();
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            M = Integer.parseInt(br.readLine());
            int idx=0;
            int cnt=0;
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<M; i++){
                String command = st.nextToken();
                switch(command){
                    case "I":
                        idx = Integer.parseInt(st.nextToken());
                        cnt = Integer.parseInt(st.nextToken());
                        for(int j=0; j<cnt; j++){
                            list.add(idx++, Integer.parseInt(st.nextToken()));
                        }
                        break;
                    case "D":
                        idx = Integer.parseInt(st.nextToken());
                        cnt = Integer.parseInt(st.nextToken());
                        list.remove(idx+cnt);
                        break;
                    case "A":
                        cnt = Integer.parseInt(st.nextToken());
                        for(int j=0; j<cnt; j++){
                            list.addLast(Integer.parseInt(st.nextToken()));
                        }
                        break;
                }
            }
            for(int i=0; i<10; i++){
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}