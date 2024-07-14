import sys
input = sys.stdin.readline

a = [0]
b = [0]

m, n = map(int, input().split())
a.append(m)
b.append(n)
t = int(input().strip())
for _ in range(t):
    x, y = map(int, input().split())
    if x == 0:
        b.append(y)
    else:
        a.append(y)

a.sort()
b.sort()

tmp = []
for i in range(1, len(a)):
    for j in range(1, len(b)):
        tmp.append((a[i] - a[i-1]) * (b[j]-b[j-1]))

print(max(tmp))