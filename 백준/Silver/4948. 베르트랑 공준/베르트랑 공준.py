import sys
input = sys.stdin.readline

li = [0, 0] + [1]*246911
for i in range(2, 246913):
    if li:
        for j in range(2*i, 246913, i):
            li[j]=0

while True:
    n = int(input().strip())
    if n == 0:
        break
    else:
        print(sum(li[n+1:2*n+1]))