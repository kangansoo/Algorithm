

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
    static int[] nums, cnt = new int[4];
    static char[] ops;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        ops = new char[N-1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth) {
        if(depth==N-1) {
            int value = calc();
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }

        for(int i=0; i<4; i++) {
            if(cnt[i]==0) continue;
            cnt[i]--;
            ops[depth]="+-*/".charAt(i);
            dfs(depth+1);
            cnt[i]++;
        }
    }

    static int calc() {
        Deque<Integer> num = new ArrayDeque<>();
        Deque<Character> op = new ArrayDeque<>();

        num.addLast(nums[0]);
        for(int i=0; i<N-1; i++) {
            char o = ops[i];
            int next = nums[i+1];

            if(o=='+' || o=='-') {
                num.addLast(next);
                op.addLast(o);
            } else {
                int left = num.pollLast();
                int tmp;
                if(o=='*') {
                    tmp = left*next;
                } else {
                    tmp = left/next;
                }
                num.addLast(tmp);
            }
        }

        int res = num.pollFirst();
        while(!op.isEmpty()) {
            char o = op.pollFirst();
            int right = num.pollFirst();
            if(o=='+') {
                res+=right;
            } else {
                res-=right;
            }
        }

        return res;
    }
}
