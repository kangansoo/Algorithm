import sys
sys.setrecursionlimit(10**6)
input=sys.stdin.readline

d=[(0, 1), (0, -1), (1, 0), (-1, 0)]

def dfs(x, y):
    visited[x][y]=True
    cnt=1
    for dx, dy in d:
        nx, ny = dx+x, dy+y
        if 0<=nx<n and 0<=ny<m and not visited[nx][ny] and graph[nx][ny]==1:
            visited[nx][ny] = True
            cnt += dfs(nx, ny)
    return cnt

n, m = map(int, input().split())
visited = [[False]*m for _ in range(n)]
graph = [list(map(int, input().split())) for _ in range(n)]

result=[]
for x in range(n):
    for y in range(m):
        if not visited[x][y] and graph[x][y]==1:
            result.append(dfs(x, y))

if result:
    print(len(result), max(result), sep="\n")
else:
    print(0, 0, sep="\n")