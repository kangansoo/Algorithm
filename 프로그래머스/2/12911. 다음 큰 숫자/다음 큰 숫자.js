function solution(n) {
    var answer = n+1;
    let target = countOne(n);
    
    while(true) {
        if(countOne(answer)===target) return answer;
        else answer++;
    }
}

function countOne(num) {
    let binary = "";
    let cnt=0;
    
    if(num===0) return 0;
    
    while(num>0) {
        binary = (num%2)+binary;
        num = Math.floor(num/2);
    }
    
    for(let cha of binary) {
        if(cha==="1") cnt++;
    }
    
    return cnt;
}