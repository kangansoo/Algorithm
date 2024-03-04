import sys
n, m = map(int, sys.stdin.readline().split())
dic = {}
dic2 = {}

for i in range(1, n+1):
    a = sys.stdin.readline().strip()
    dic[i] = a
    dic2[a] = i

for _ in range(m):
    b = sys.stdin.readline().strip()
    if b.isdigit():
        print(dic[int(b)])
    else:
        print(dic2[b])