from collections import deque
import sys

input = sys.stdin.readline
n = int(input().strip())
a, b = map(int, input().split())
m = int(input().strip())

def bfs(x):
    q = deque([x])
    visited = [False] * (n+1)
    visited[x]=True
    distances = [0] * (n+1)
    while q:
        node = q.popleft()
        for i in graph[node]:
            if not visited[i]:
                distances[i] = distances[node]+1
                visited[i]=True
                q.append(i)
    return distances

graph = [[] for _ in range(n+1)]
for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

arr = bfs(a)
result = arr[b]

print(result if result != 0 else -1)