import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

d = [(0, 1), (0, -1), (1, 0), (-1, 0)]

def dfs(x, y, z):
    visited[x][y] = True
    for dx, dy in d:
        X, Y = x + dx, y + dy
        if 0 <= X < n and 0 <= Y < n and graph[X][Y] > z and not visited[X][Y]:
            dfs(X, Y, z)

answer = 1
max_height = max(map(max, graph))
for z in range(max_height):
    visited = [[False] * n for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):
            if graph[i][j] > z and not visited[i][j]:
                cnt += 1
                dfs(i, j, z)
    answer = max(answer, cnt)

print(answer)