import sys
from collections import deque
input = sys.stdin.readline

d=[(1, 2), (1, -2), (-1, 2), (-1, -2), (2, 1), (2, -1), (-2, 1), (-2, -1)]

def bfs(x, y):
    q = deque()
    q.append((x, y))
    graph[x][y]=0
    while q:
        x, y = q.popleft()
        if x==a and y==b:
            return graph[x][y]
        for dx, dy in d:
            nx, ny = dx + x, dy + y
            if 0<=nx<m and 0<=ny<m and graph[nx][ny]==0:
                graph[nx][ny] = graph[x][y] + 1
                q.append((nx, ny))

k = int(input().strip())
for _ in range(k):
    m = int(input().strip())
    graph = [[0]*m for _ in range(m)]
    x, y = map(int, input().split())
    a, b = map(int, input().split())
    print(bfs(x, y))