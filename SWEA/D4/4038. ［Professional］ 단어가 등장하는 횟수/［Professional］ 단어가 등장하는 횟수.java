import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static final int E1 = 31, E2 = 33, E3=17; // 해시 계산에 사용할 제곱수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=T; t++) {
            String string = br.readLine(); // 전체 문자열
            String pattern = br.readLine(); // 찾는 패턴 문자열

            sb.append("#").append(t).append(" ").append(getCount(string, pattern)).append("\n");

        }
        System.out.println(sb);

        br.close();
    }

    // 라빈 카프 알고리즘
    static int getCount(String string, String pattern) {
        int cnt=0;

        int stringLength = string.length(); // 전체 문자열의 길이
        int patternLength = pattern.length(); // 패턴 문자열의 길이

        // 해시 값 초기화
        int hash1 = 0;
        int hash2 = 0;
        int hash3 = 0;

        // 패턴의 해시 값 초기화
        int hashPattern1=0;
        int hashPattern2=0;
        int hashPattern3=0;

        // 제곱수 초기화
        int power1=1;
        int power2=1;
        int power3=1;

        // 라빈 카프 알고리즘 핵심 부분
        for(int i=0; i<=stringLength-patternLength; i++) {
            if(i==0) { // 첫 탐색에는 현재 문자열과 패턴 문자열의 해시 값을 각각 초기화
                for(int j=0; j<patternLength; j++) {
                    hash1 += hash(string.charAt(patternLength-1-j), power1);
                    hashPattern1 += hash(pattern.charAt(patternLength-1-j), power1);

                    hash2 += hash(string.charAt(patternLength-1-j), power2);
                    hashPattern2 += hash(pattern.charAt(patternLength-1-j), power2);

                    hash3 += hash(string.charAt(patternLength-1-j), power3);
                    hashPattern3 += hash(pattern.charAt(patternLength-1-j), power3);

                    // 가장 마지막에 사용한 제곱수는 계속 사용해야 하므로 증가하지 않고 저장
                    if(j<patternLength-1) { // <= E^(패턴 문자열-1)
                        power1*=E1;
                        power2*=E2;
                        power3*=E3;
                    }
                }
            } else {
                /*
                  첫탐색이 아니라면 hash 값에 (이전 문자열의 첫 번째 문자)^power(E^(패턴 문자열-1))을 빼고
                  E(제곱수)를 곱한 후에 현재 문자열의 가장 마지막 문자 값을 더하기
                */
                hash1 = (hash1-hash(string.charAt(i-1), power1))*E1+string.charAt(patternLength-1+i);
                hash2 = (hash2-hash(string.charAt(i-1), power2))*E2+string.charAt(patternLength-1+i);
                hash3 = (hash3-hash(string.charAt(i-1), power3))*E3+string.charAt(patternLength-1+i);
            }

            // 해시 충돌을 방지하기 위해 다중 해시로 검사
            if(hash1==hashPattern1 && hash2==hashPattern2 && hash3==hashPattern3) {
                cnt++;
            }
        }

        return cnt;
    }

    static int hash(int value, int power) {
        return value*power;
    }
}
