def dfs(x):
    if len(result)==m:
        print(*result)
        return
    for i in range(x, n+1):
        result.append(i)
        dfs(i)
        result.pop()

n, m = map(int, input().split())
result=[]
dfs(1)