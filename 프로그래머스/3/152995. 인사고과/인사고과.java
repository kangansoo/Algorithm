import java.util.*;

class Solution {
    static class Person {
        int x;
        int y;
        int t;
        boolean isWanho;
        
        public Person(int x, int y, int t, boolean isWanho) {
            this.x=x;
            this.y=y;
            this.t=t;
            this.isWanho=isWanho;
        }
    }
    public int solution(int[][] scores) {
        int answer = 1;
        int n=scores.length;
        Person wanho = new Person(scores[0][0], scores[0][1], scores[0][0] + scores[0][1], true);
        
        Person[] sorted = new Person[n];
        
        for(int i=0; i<n; i++) {
            int[] p = scores[i];
            sorted[i] = new Person(p[0], p[1], p[0]+p[1], i==0);
        }
        
        Arrays.sort(sorted, (a, b)-> {
            if(a.x==b.x) return a.y-b.y;
            return b.x-a.x;
        });
        
        int maxY=0;
        
        for(Person p:sorted) {
            if(p.y<maxY) {
                if(p.isWanho) return -1;
                continue;
            }
            
            maxY = Math.max(maxY, p.y);
            
            if(p.t>wanho.t) answer++;
        }
        
        return answer;
    }
}