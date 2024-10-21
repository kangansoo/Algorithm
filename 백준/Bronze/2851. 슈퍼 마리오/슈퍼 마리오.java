import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] li = new int[10];
        li[0] = Integer.parseInt(br.readLine());
        for(int i=1; i<10; i++){
            li[i] = li[i-1] + Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for(int l:li){
            if(Math.abs(100-l)<=Math.abs(100-answer)) answer=l;
        }
        System.out.println(answer);
    }
}