def backtracking():
    if(len(result)) == m:
        # print(' '.join(map(str, result)))
        print(*result)
        return
    for i in range(1, n+1):
        if visited[i]:
            continue
        visited[i]=True
        result.append(i)
        backtracking()
        result.pop()
        visited[i]=False

n, m = map(int, input().split())
visited=[False]*(n+1)
result=[]
backtracking()