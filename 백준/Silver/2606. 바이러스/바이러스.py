import sys
input = sys.stdin.readline

n = int(input())
m = int(input())

def dfs(x):
    visited[x] = True
    global cnt
    cnt += 1
 
    for i in graph[x]:
        if not visited[i]:
            dfs(i)

graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (n+1)
cnt = 0
dfs(1)
print(cnt-1)