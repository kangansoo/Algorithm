import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    static int N, M;
    static int[] parents;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parents = new int[N+1];
            Set<Integer> set = new HashSet<>();
            // 모든 원소에 대해 단위 서러소집합 생성
            make();
            
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                union(a, b);
            }
            // Find unique roots
            Set<Integer> rootSet = new HashSet<>();
            for(int i = 1; i <= N; i++) {
                rootSet.add(findSet(i));
            }
            sb.append(rootSet.size()).append("\n");
        }
        System.out.println(sb);
    }
    
    static void make() {
        for(int i=0; i<=N; i++) {
            parents[i]=i; // make-set(i) : 자신의 부모를 자신으로 하여 대표자가 되도록 설정
        }
    }
    
    static int findSet(int a) {
        if(a != parents[a]) {
            parents[a] = findSet(parents[a]); // Path compression
        }
        return parents[a];
    }
    
    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false; // 두 집합의 대표자가 같으면 이미 같은 집합이므로 합집합 연산 불가
        
        // aRoot에 bRoot를 흡수 : 두 집합 합치기
        parents[bRoot] = aRoot;
        
        return true;
    }
}