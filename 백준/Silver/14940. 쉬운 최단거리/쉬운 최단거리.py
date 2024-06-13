from collections import deque
import sys
input = sys.stdin.readline

d = [(0, 1), (0, -1), (1, 0), (-1, 0)]
def bfs(x, y):
    q = deque()
    q.append((x, y))
    visited[x][y]= True
    map[x][y]=0
    while q:
        x, y = q.popleft()
        for nx, ny in d:
            dx, dy = x + nx, y + ny
            if 0<=dx<n and 0<=dy<m and map[dx][dy]==1 and not visited[dx][dy]:
                visited[dx][dy]=True
                map[dx][dy]=map[x][y]+1
                q.append((dx, dy))
    for i in range(n):
        for j in range(m):
            if map[i][j] == 1 and not visited[i][j]:
                map[i][j] = -1
                
n, m = map(int, input().split())
visited = [[False]*(m) for _ in range(n)]
map = [list(map(int, input().split())) for _ in range(n)]
for i, row in enumerate(map):
    for j, ele in enumerate(row):
        if map[i][j]==2 and not visited[i][j]:
            bfs(i,j)
            
for rows in map:
    print(*rows)