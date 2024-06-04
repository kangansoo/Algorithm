import sys
from collections import deque
input = sys.stdin.readline

d= [(0, 1), (0, -1), (1, 0), (-1, 0)]
def bfs(q):
    while q:
        cx, cy = q.popleft()
        for dx, dy in d:
            nx, ny = cx + dx, cy + dy
            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:
                graph[nx][ny]=graph[cx][cy]+1
                q.append((nx, ny))

q = deque()
m, n = map(int, input().split())
graph = [[] for _ in range(n)]
for i in range(n):
    graph[i]=list(map(int, input().split()))

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            q.append([i, j])
bfs(q)

cnt=0
visit=True
for row in graph:
    for i in row:
        if i == 0:
            visit=False
            break
    cnt = max(cnt, max(row))

if visit:
    print(cnt-1)
else:
    print(-1)