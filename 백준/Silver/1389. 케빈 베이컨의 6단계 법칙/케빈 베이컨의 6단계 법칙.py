from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

def bfs(x):
    q = deque([x])
    distance = [0] * (n + 1)
    visited = [False] * (n + 1)
    visited[x] = True
    while q:
        node = q.popleft()
        for i in graph[node]:
            if not visited[i]:
                distance[i] = distance[node] + 1
                visited[i] = True
                q.append(i)
    return sum(distance)

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

distances = []
for i in range(1, n + 1):
    distances.append(bfs(i))

print(distances.index(min(distances)) + 1)