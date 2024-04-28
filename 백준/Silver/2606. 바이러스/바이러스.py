import sys
input = sys.stdin.readline

n = int(input())
m = int(input())


# 재귀함수로 구현한 DFS
def dfs(x):
    visited[x] = True
    global cnt
    cnt += 1
 
    for i in graph[x]:
        if not visited[i]:
            dfs(i)
  
# 각 노드가 연결된 정보를 리스트 자료형으로 표현(2차원 리스트)
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 각 노드가 방문된 정보를 리스트 자료형으로 표현(1차원 리스트) - 0부터 시작하기 때문에 9개 곱하기
visited = [False] * (n+1)
cnt = 0
# 정의된 BFS 함수 호출
dfs(1)
print(cnt-1)