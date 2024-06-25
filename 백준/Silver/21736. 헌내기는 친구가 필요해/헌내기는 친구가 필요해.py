import sys
from collections import deque
input = sys.stdin.readline

d = [(0, 1), (0, -1), (1, 0), (-1, 0)]

def bfs(x, y):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    cnt = 0
    
    while q:
        x, y = q.popleft()
        for dx, dy in d:
            nx, ny = dx + x, dy + y
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and graph[nx][ny] != 'X':
                visited[nx][ny] = True
                if graph[nx][ny] == 'P':
                    cnt += 1
                q.append((nx, ny))
                
    return cnt

n, m = map(int, input().split())
graph = [list(input().strip()) for _ in range(n)]
visited = [[False] * m for _ in range(n)]

result = 0
for x in range(n):
    for y in range(m):
        if graph[x][y] == 'I':
            result = bfs(x, y)
            break

if result == 0:
    print('TT')
else:
    print(result)
