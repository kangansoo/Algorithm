function solution(n,a,b)
{
    var answer = 1;

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    console.log('Hello Javascript')
    
    while(true) {
        if(a%2===0 && b%2!==0) {
            if(b+1===a) break;
        } else if(a%2!==0 && b%2===0) {
            if(a+1===b) break;
        }
        
        if(a%2===0) {
            a/=2;
        } else {
            a = Math.floor(a/2)+1;
        }
        
        if(b%2===0) {
            b/=2;
        } else {
            b = Math.floor(b/2)+1;
        }
        
        answer++;
    }

    return answer;
}