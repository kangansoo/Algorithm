function solution(people, limit) {
    var answer = 0;
    people.sort((a,b)=>a-b);
    
    let l=0, r=people.length-1;
    
    while(l<=r) {
        if(people[r--]+people[l]<=limit) l++;
        answer++;
    }
    
    return answer;
}