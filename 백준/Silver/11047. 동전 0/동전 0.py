import sys
input = sys.stdin.readline
n, k = map(int, input().split())
coins = []
for i in range(n):
    coins.append(int(input().strip()))
coins.sort(reverse=True)

cnt = 0
for coin in coins:
    if k >= coin:
        cnt += k // coin
        k %= coin
    if k == 0:
        break

print(cnt)