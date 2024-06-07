from collections import deque
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

m, n, k = map(int, input().strip().split())

dis = [(1, 0), (-1, 0), (0, 1), (0, -1)]

def dfs(x, y, cnt):
    graph[x][y] = 1
    for dx, dy in dis:
        nx, ny = x + dx, y + dy
        if 0 <= nx < m and 0 <= ny < n and graph[nx][ny] == 0:
            graph[nx][ny] = 1
            cnt+=1
            cnt = dfs(nx, ny, cnt)
    return cnt

graph = [[0]*n for _ in range(m)]

for _ in range(k):
    a, b, c, d = map(int, input().strip().split())
    for i in range(b, d):
        for j in range(a, c):
            graph[i][j] = 1

cnts = []
cnt=1
for i in range(m):
    for j in range(n):
        if graph[i][j] == 0:
            temp = dfs(i, j, cnt)
            cnts.append(temp)

print(len(cnts))
print(*sorted(cnts))
