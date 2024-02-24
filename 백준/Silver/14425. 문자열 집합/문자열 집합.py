n, m = map(int, input().split())
s = set()
z = set()
cnt=0

for _ in range(n):
    s.update(map(str, input().split()))

for _ in range(m):
    data = input().strip()
    if data in s:
        cnt += 1
print(cnt)