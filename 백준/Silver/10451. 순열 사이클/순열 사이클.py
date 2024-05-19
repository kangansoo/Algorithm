import sys
input = sys.stdin.readline

def dfs(x, li, visited):
    visited[x] = True
    for i in li[x]:
        if not visited[i]:
            dfs(i, li, visited)

n = int(input())
for _ in range(n):
    i = int(input())
    arr = list(map(int, input().split()))
    li = [[] for _ in range(i + 1)]

    for idx in range(1, i + 1):
        li[idx].append(arr[idx - 1])
    
    visited = [False] * (i + 1)
    cnt = 0
    for j in range(1, i + 1):
        if not visited[j]:
            dfs(j, li, visited)
            cnt += 1
    print(cnt)