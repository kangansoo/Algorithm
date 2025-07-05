import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 각 칸에 대한 클래스
    static class Space {
        int durability; // 내구도
        boolean robot; // 로봇 존재 여부

        public Space(int durability, boolean robot) {
            this.durability = durability;
            this.robot = robot;
        }
    }

    static int N, K, zero;
    static Space[] conveyor; // 각 칸으로 이루어진 컨베이어 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        zero=0; // 내구성이 0인 칸들의 개수

        conveyor = new Space[2*N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++){
            int num = Integer.parseInt(st.nextToken());
            conveyor[i] = new Space(num, false);
        }

        System.out.println(simulation());
    }

    static int simulation(){ // 시뮬레이션 함수
        int cnt=0;
        while(zero<K){

            // 컨베이어 벨트 오른쪽으로 이동
            Space tmp = conveyor[2*N-1];
            for (int i=2*N-1; i>0; i--) {
                conveyor[i] = conveyor[i-1];
            }
            conveyor[0] = tmp;

            unloading(); // 로봇 내리기

            // 로봇 이동
            for(int i=N-2; i>=0; i--){
                if(conveyor[i].robot){
                    if(!conveyor[i+1].robot && conveyor[i+1].durability>=1){
                        conveyor[i].robot = false;
                        conveyor[i+1].robot = true;
                        conveyor[i+1].durability -= 1;
                    }
                }
            }

            unloading(); // 로봇 내리기

            // 로봇 올리기
            if(conveyor[0].durability>=1 && !conveyor[0].robot){
                conveyor[0].robot=true;
                conveyor[0].durability -= 1;
            }

            check(); // 내구성이 0인 칸의 개수 구하기

            cnt++;
        }

        return cnt;
    }

    // 내구성이 0인 칸의 개수 구하는 함수
    static void check(){
        int tmp=0;
        for(int i=0; i<2*N; i++){
            if(conveyor[i].durability==0){
                tmp++;
            }
        }
        zero=tmp;
    }

    // 로봇 내리기
    static void unloading(){
        if(conveyor[N-1].robot){
            conveyor[N-1].robot=false;
        }
    }
}
