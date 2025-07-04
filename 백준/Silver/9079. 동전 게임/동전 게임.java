import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int[] flipMask;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        generateFlipMask();
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int mask = 0;
            char[][] arr = new char[3][3];

            for(int i=0; i<3; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<3; j++){
                    arr[i][j]=st.nextToken().charAt(0);
                }
            }

            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    mask<<=1;
                    if(arr[i][j]=='T'){
                        mask |= 1;
                    }
                }
            }
            System.out.println(bfs(mask));
        }
    }

    static int bfs(int mask){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[512];
        int cnt = 0;
        q.add(mask);
        visited[mask]=true;

        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int curr = q.poll();

                if(curr==511 || curr==0) return cnt;

                for(int d=0; d<8; d++){
                    int next = curr^flipMask[d];
                    if(!visited[next]){
                        visited[next]=true;
                        q.add(next);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    static void generateFlipMask(){
        flipMask = new int[8];
        int idx = 0;
        int mask;
        for(int i=0; i<3; i++){
            mask = 0;
            for(int j=0; j<3; j++){
                mask |= (1<<i*3+j);
            }
            flipMask[idx++] = mask;
        }

        for(int i=0; i<3; i++){
            mask = 0;
            for(int j=0; j<3; j++){
                mask |= (1<<j*3+i);
            }
            flipMask[idx++] = mask;
        }
        mask=0;
        for(int i=0; i<3; i++){
            mask |= (1 << (i * 3 + i));
        }
        flipMask[idx++] = mask;

        mask=0;
        for(int i=0; i<3; i++){
            mask |= (1 << (i * 3 + (2 - i)));
        }
        flipMask[idx] = mask;
    }
}
