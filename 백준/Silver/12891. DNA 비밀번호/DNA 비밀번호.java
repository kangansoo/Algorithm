import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int S, P, check[], pCheck[], point;
    static char[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        str = br.readLine().toCharArray();

        check = new int[4];
        pCheck = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }
        point = 0;

        // 첫 번째 윈도우 초기화
        for(int i=0; i<P; i++){
            addChar(str[i]);
        }

        // 첫 번째 윈도우 체크
        if(checkPoint()) point++;

        // 슬라이딩 윈도우
        for(int i=P; i<S; i++){
            int j = i - P;
            addChar(str[i]);
            removeChar(str[j]);

            if(checkPoint()) point++;
        }

        System.out.println(point);
    }

    private static void addChar(char c) {
        switch (c) {
            case 'A': pCheck[0]++; break;
            case 'C': pCheck[1]++; break;
            case 'G': pCheck[2]++; break;
            case 'T': pCheck[3]++; break;
        }
    }

    private static void removeChar(char c) {
        switch (c) {
            case 'A': pCheck[0]--; break;
            case 'C': pCheck[1]--; break;
            case 'G': pCheck[2]--; break;
            case 'T': pCheck[3]--; break;
        }
    }

    private static boolean checkPoint() {
        for(int i=0; i<4; i++){
            if(check[i] > pCheck[i]){
                return false;
            }
        }
        return true;
    }
}