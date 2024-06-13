import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def dfs(r):
    global cnt
    visited[r]=cnt
    cnt+=1
    for i in sorted(graph[r], reverse=True):
        if visited[i] == 0:
            visited[i]=cnt
            dfs(i)

n, m, r = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited=[0]*(n+1)
for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

cnt = 1
dfs(r)
print('\n'.join(map(str, visited[1:])))