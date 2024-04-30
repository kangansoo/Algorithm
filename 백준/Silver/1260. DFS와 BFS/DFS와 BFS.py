import sys
from collections import deque

input = sys.stdin.readline
n, m, v = map(int, input().split())

def dfs(v):
    visited[v] = True
    print(v, end=" ")
    for i in graph[v]:
        if not visited[i]:
            dfs(i)

def bfs(v):
    queue = deque([v])
    visited[v] = True
    while queue:
        q = queue.popleft()
        print(q, end=" ")
        for i in graph[q]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    graph[a].sort()
    graph[b].sort()

visited = [False] * (n+1)
dfs(v)
visited = [False] * (n+1)
print()
bfs(v)