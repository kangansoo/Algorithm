import sys
from collections import deque

input = sys.stdin.readline

def bfs(x):
    q = deque([x])
    visited[x] = 1
    while q:
        x = q.popleft()
        for i in graph[x]:
            if visited[i] == 0:
                visited[i] = visited[x] + 1
                q.append(i)

n = int(input().strip())
m = int(input().strip())

graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)
result=[]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

bfs(1)
for i in visited:
    if 1 < i <= 3:
        result.append(i)
print(len(result))