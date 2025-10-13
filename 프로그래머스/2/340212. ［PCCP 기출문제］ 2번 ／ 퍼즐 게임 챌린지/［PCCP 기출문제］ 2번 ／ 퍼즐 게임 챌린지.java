class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int left=1;
        int right=0;
        for(int d:diffs) {
            right = Math.max(right, d);
        }
        
        while(left<=right) {
            int mid = (left+right)/2;
            
            if(countTime(mid, diffs, times)>limit) {
                left=mid+1;
            } else {
                right=mid-1;
                answer=mid;
            }
        }
        
        return answer;
    }
    
    static long countTime(int level, int[] diffs, int[] times) {
        long t=0;
        for(int i=0; i<diffs.length; i++) {
            if(diffs[i]<=level) {
                t+=(long)times[i];
            } else {
                t+=(long)(times[i-1]+times[i])*(diffs[i]-level)+times[i];
            }
        }
        
        return t;
    }
}