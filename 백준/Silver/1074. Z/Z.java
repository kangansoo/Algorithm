import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, R, C, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		cnt = 0;
		int n = (int) Math.pow(2, N);
		
		divide(0, 0, n);
		
	}
	
	static void divide(int r, int c, int size) {
        if (size == 1) {
            System.out.println(cnt);
            return;
        }

        int half = size / 2;

        // 1사분면
        if (R < r + half && C < c + half) {
            divide(r, c, half);
        }
        // 2사분면
        else if (R < r + half && C >= c + half) {
            cnt += half * half;
            divide(r, c + half, half);
        }
        // 3사분면
        else if (R >= r + half && C < c + half) {
            cnt += 2 * half * half;
            divide(r + half, c, half);
        }
        // 4사분면
        else if (R >= r + half && C >= c + half) {
            cnt += 3 * half * half;
            divide(r + half, c + half, half);
        }
    }
	
}