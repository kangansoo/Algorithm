import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def dfs(x, cnt):
    visited[x] = True
    for i in graph[x]:
        if not visited[i]:
            cnt = dfs(i, cnt + 1)
    return cnt

t = int(input().strip())

for _ in range(t):
    n, m = map(int, input().split())
    graph = [[] for _ in range(n+1)]
    visited = [False]*(n+1)
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    for i in range(1, n+1):
        if not visited[i]:
            print(dfs(i, 0))