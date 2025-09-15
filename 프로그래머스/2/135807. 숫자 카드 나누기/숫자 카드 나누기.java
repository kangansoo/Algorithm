import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int n = arrayA.length;
        int m = arrayB.length;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int x = arrayA[0];
        for(int i=1; i<n; i++) {
            x = gcd(arrayA[i], x);
        }
        
        int y = arrayB[0];
        for(int i=1; i<m; i++) {
            y = gcd(arrayB[i], y);
        }
        
        if(!isDivide(arrayB, x)) {
            answer = Math.max(answer, x);
        }
        
        if(!isDivide(arrayA, y)) {
            answer = Math.max(answer, y);
        }
        
        return answer;
    }
    
    static int gcd(int x, int y) {
        if(y==0) {
            return x;
        } else {
            return gcd(y, x%y);
        }
    }
    
    static boolean isDivide(int[] arr, int y) {
        boolean flag=false;
        
        if(y<=1) return true;
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i]%y==0) return true;
        }
        
        return false;
    }
}