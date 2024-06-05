import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def dfs(x):
    for i in graph[x]:
        if not visited[i]:
            visited[i] = True
            parent[i] = x
            dfs(i)

n = int(input().strip())
visited = [False] * (n + 1)
parent = [0] * (n + 1)
graph = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited[1] = True
dfs(1)

print('\n'.join(map(str, parent[2:])))