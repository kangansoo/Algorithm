import sys
from collections import deque
input = sys.stdin.readline

d= [(-1, 0), (1, 0), (0, -1), (0, 1)]
def bfs(x, y):
    q = deque([(x, y)])
    visited[x][y]=True
    cnt = 1
    while q:
        x, y = q.popleft()
        for dx, dy in d:
            nx, ny = dx+x, dy+y
            if 0<=nx<n and 0<=ny<m and not visited[nx][ny] and graph[nx][ny] == 1:
                visited[nx][ny]=True
                cnt+=1
                q.append((nx, ny))
    return cnt

n, m, k = map(int, input().split())
graph = [[0]*m for _ in range(n)]
visited = [[False]*m for _ in range(n)]

for _ in range(k):
    a, b = map(int, input().split())
    graph[a-1][b-1] = 1

result = []
for i in range(n):
    for j in range(m):
        if not visited[i][j] and graph[i][j] == 1:
            result.append(bfs(i, j))

print(max(result))