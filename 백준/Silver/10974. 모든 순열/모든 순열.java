import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] numbers;
    static boolean[] isSelected;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        isSelected = new boolean[N + 1];

        perm(0);
        System.out.println(sb);
    }

    static void perm(int cnt) {
        if (cnt == N) {
            for (int n : numbers) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isSelected[i]) continue;
            numbers[cnt] = i;
            isSelected[i] = true;
            perm(cnt + 1);
            isSelected[i] = false;
        }
    }
}