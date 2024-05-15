import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
n = int(input())

d = [(0,1), (0, -1), (1,0), (-1,0)]
def dfs(x, y):
    visited[x][y] = True
    color = graph[x][y]
    for dx, dy in d:
        X, Y = x + dx, y + dy
        if (0 <= X < n) and (0 <= Y < n):
            if visited[X][Y] == False and graph[X][Y] == color:
                dfs(X, Y)

cnt, cnt2 = 0, 0
graph = []
for i in range(n):
    graph.append(list(map(str, input().strip())))
visited = [[False] * n for _ in range(n)]

for i in range(n):
    for j in range(n):
        if visited[i][j]==False:
            dfs(i, j)
            cnt += 1

visited = [[False] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if graph[i][j] == 'G':
            graph[i][j] = 'R'

for i in range(n):
    for j in range(n):
        if visited[i][j] == False:
            dfs(i, j)
            cnt2 += 1
            
print(cnt, cnt2)