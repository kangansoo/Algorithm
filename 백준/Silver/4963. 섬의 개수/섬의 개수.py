from collections import deque
import sys
input = sys.stdin.readline

d = [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]

def bfs(x, y):
    q = deque()
    q.append((x, y))
    graph[x][y] = 0
    while q:
        x, y = q.popleft()
        for dx, dy in d:
            nx, ny = x + dx, y + dy
            if 0 <= nx < h and 0 <= ny < w and graph[nx][ny] == 1:
                q.append((nx, ny))
                graph[nx][ny] = 0

result = []
while True:
    cnt = 0
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    graph = [list(map(int, input().split())) for _ in range(h)]

    for i in range(h):
        for j in range(w):
            if graph[i][j] == 1:
                bfs(i, j)
                cnt+=1
    result.append(cnt)

print(*result, sep="\n")