n, m = map(int, input().split())
a = set(input() for _ in range(n))
b = set(input() for _ in range(m))
li = list(a.intersection(b))

print(len(li))
for i in sorted(li):
    print(i)