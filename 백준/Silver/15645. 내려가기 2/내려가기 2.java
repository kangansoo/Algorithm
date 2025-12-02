

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][3];
        int[][] dpMin = new int[N][3];
        int[][] dpMax = new int[N][3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
            points[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<3; i++) {
            dpMin[0][i] = dpMax[0][i] = points[0][i];
        }

        for(int i=1; i<N; i++) {
            dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1])+points[i][0];
            dpMin[i][1] = Math.min(dpMin[i-1][0], Math.min(dpMin[i-1][1], dpMin[i-1][2]))+points[i][1];
            dpMin[i][2] = Math.min(dpMin[i-1][2], dpMin[i-1][1])+points[i][2];

            dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1])+points[i][0];
            dpMax[i][1] = Math.max(dpMax[i-1][0], Math.max(dpMax[i-1][1], dpMax[i-1][2]))+points[i][1];
            dpMax[i][2] = Math.max(dpMax[i-1][2], dpMax[i-1][1])+points[i][2];
        }

        int min=Integer.MAX_VALUE;
        int max=0;
        for(int i=0; i<3; i++) {
            max = Math.max(dpMax[N-1][i], max);
            min = Math.min(dpMin[N-1][i], min);
        }

        System.out.println(max+" "+min);
    }
}
