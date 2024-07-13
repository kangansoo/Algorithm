import sys
input = sys.stdin.readline
n, k = map(int, input().split())
cnt = 0
arr = [[0]*6 for _ in range(2)]

for _ in range(n):
    a, b = map(int, input().split())
    arr[a][b-1] += 1

for i in arr:
    for j in i:
        if j % k == 0:
            cnt += j // k
        else:
            cnt += j // k + 1

print(cnt)