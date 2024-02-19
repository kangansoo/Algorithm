n = int(input())
x=[]
y=[]

for _ in range(n):
    a, b = map(int, input().split())
    x.append(a)
    y.append(b)

x1 = max(x) - min(x)

y1 = max(y) - min(y)

    
if n<2:
    print(0)
else:
    print(x1*y1)
