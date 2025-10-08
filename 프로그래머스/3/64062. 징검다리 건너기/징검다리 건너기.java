class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left=1;
        int right=200000000;
        
        while(left<=right) {
            int mid = (left+right)/2;
            
            if(isPossible(stones, k, mid)) {
                answer=mid;
                left=mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return answer;
    }
    
    static boolean isPossible(int[] stones, int k, int mid) {
        int zero=0;
        for(int stone:stones) {
            if(stone<mid) {
                zero++;
                if(zero>=k) return false;
            } else {
                zero=0;
            }
        }
        return true;
    }
}