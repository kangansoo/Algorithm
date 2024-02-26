n = int(input())
li = [[0]*100 for _ in range(100)]
cnt=0

for _ in range(n):
    a, b = map(int, input().split())
    for i in range(a, a+10):
        for j in range(b, b+10):
            li[i][j]=1

for i in range(100):
    for j in range(100):
        if li[i][j]:
            cnt+=1
print(cnt)