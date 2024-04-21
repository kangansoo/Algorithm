n=int(input())

time = [300, 60, 10]
result = []
for i in time:
    result.append(n//i)
    n=n%i
if n >0:
    print(-1)
else:
    print(*result)