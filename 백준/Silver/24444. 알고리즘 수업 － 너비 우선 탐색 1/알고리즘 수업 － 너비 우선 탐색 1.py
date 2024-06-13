from collections import deque
import sys
input = sys.stdin.readline

def bfs(x):
    q = deque()
    q.append(x)
    global cnt
    visited[x] = cnt
    while q:
        x = q.popleft()
        graph[x].sort()
        for i in graph[x]:
            if visited[i] == 0:
                cnt+=1
                visited[i] = cnt
                q.append(i)            

n, m, r = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited=[0]*(n+1)
for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

cnt = 1
bfs(r)
print('\n'.join(map(str, visited[1:])))