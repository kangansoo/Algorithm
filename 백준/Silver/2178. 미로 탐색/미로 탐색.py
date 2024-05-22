import sys
from collections import deque
input = sys.stdin.readline

def bfs(n, m, maps):
    q = deque()
    q.append((0, 0))
    visited[0][0] = True
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx <n and 0 <= ny < m:
                if maps[nx][ny] == 1 and not visited[nx][ny]:
                    q.append((nx, ny))
                    visited[nx][ny] = True
                    maps[nx][ny] = maps[x][y] + 1
    if maps[n-1][m-1] == 1:
        return -1
    else:
        return maps[n-1][m-1]
    

n, m = map(int, input().split())
maps = [list(map(int, input().strip())) for _ in range(n)]
visited=[[False]*m for _ in range(n)]

print(bfs(n, m, maps))