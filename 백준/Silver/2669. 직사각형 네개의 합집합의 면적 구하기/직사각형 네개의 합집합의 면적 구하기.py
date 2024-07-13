import sys
input = sys.stdin.readline

graph = [[0]*100 for _ in range(100)]

for _ in range(4):
    a, b, c, d = map(int, input().split())
    for i in range(a, c):
        for j in range(b, d):
            graph[i][j]=1

cnt=0
for i in range(100):
    for j in range(100):
        if graph[i][j]:
            cnt += 1

print(cnt)