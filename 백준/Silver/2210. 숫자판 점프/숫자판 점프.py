import sys
input = sys.stdin.readline

d = [(0, 1), (0, -1), (1, 0), (-1, 0)]

def dfs(x, y, number):
    global result
    number += str(graph[x][y])
    if len(number) == 6:
        result.add(number)
        return
    
    for dx, dy in d:
        nx, ny = x + dx, y + dy
        if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
            dfs(nx, ny, number)

n = 5
graph = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * n for _ in range(n)]
result = set()

for i in range(n):
    for j in range(n):
        dfs(i, j, '')

print(len(result))