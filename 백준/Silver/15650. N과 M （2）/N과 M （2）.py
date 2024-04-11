def backtracking(x):
    if len(result) == m:
        print(*result)
        return
    for i in range(x, n+1):
        if not visited[i]:
            result.append(i)
            backtracking(i+1)
            result.pop()
    
n ,m = map(int, input().split())
result=[]
visited=[False]*(n+1)
backtracking(1)