import java.util.*;

class Solution {
    static class Job implements Comparable<Job> {
        int start;
        int duration;
        public Job(int start, int duration) {
            this.start=start;
            this.duration=duration;
        }
        @Override
        public int compareTo(Job o) {
            if(this.duration!=o.duration) return this.duration-o.duration;
            else  return this.start-o.start;
        }
    }
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        Arrays.sort(jobs, (a, b)->a[0]-b[0]);
        
        int idx=0;
        int time=0;
        int answer=0;
        int cnt=0;
        
        while(cnt<jobs.length) {
            while(idx<jobs.length && jobs[idx][0]<=time) {
                pq.add(new Job(jobs[idx][0], jobs[idx++][1]));
            }
            
            if(pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                Job curr = pq.poll();
                time+=curr.duration;
                answer+=time-curr.start;
                cnt++;
            }
        }
        
        return answer/jobs.length;
    }
}