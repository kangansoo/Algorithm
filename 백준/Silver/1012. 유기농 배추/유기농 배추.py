import sys
from collections import deque
input = sys.stdin.readline

d=[(1, 0), (-1, 0), (0, 1), (0, -1)]
def bfs(x, y, graph):
    q = deque()
    q.append((x, y))
    visited[x][y]=True
    while q:
        cx, cy = q.popleft()
        for dx, dy in d:
            X, Y = cx + dx, cy + dy
            if 0 <= X < n and 0 <= Y < m and graph[X][Y] == 1 and not visited[X][Y]:
                q.append((X, Y))
                visited[X][Y]=True

t = int(input().strip())
for _ in range(t):
    m, n, k = map(int, input().strip().split())
    graph = [[0] * m for _ in range(n)]
    visited=[[False]*m for _ in range(n)]
    cnt = 0
    for _ in range(k):
        x, y = map(int, input().strip().split())
        graph[y][x] = 1
    
    for x in range(n):
        for y in range(m):
            if graph[x][y] == 1 and not visited[x][y]:
                bfs(x, y, graph)
                cnt += 1

    print(cnt)