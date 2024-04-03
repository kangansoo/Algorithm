import sys
input = sys.stdin.readline

li = dict()
n, m = map(int, input().split())
for _ in range(n):
    str = input().strip()
    if len(str) >= m:
        if str in li:
            li[str] += 1
        else:
            li.update({str:1})
li = sorted(li.items(), key=lambda x:(-x[1], -len(x[0]), x[0]))

for key, value in li:
    print(key)