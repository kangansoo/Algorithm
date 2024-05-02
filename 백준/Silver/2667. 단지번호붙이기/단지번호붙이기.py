import sys
input = sys.stdin.readline
n = int(input())

def dfs(x, y):
    global cnt
    if x >= n or x < 0 or y < 0 or y >= n:
        return False
    if graph[x][y] == 1:
        graph[x][y] = 0
        cnt+=1
        dfs(x-1,y)
        dfs(x,y-1)
        dfs(x+1,y)
        dfs(x,y+1)
        return True
    return False

cnt=0
result = []
graph = []
for i in range(n):
    graph.append(list(map(int, input().strip())))

for i in range(n):
    for j in range(n):
        if dfs(i, j):
            result.append(cnt)
            cnt=0
result.sort()
print(len(result))
print(*result, sep="\n")