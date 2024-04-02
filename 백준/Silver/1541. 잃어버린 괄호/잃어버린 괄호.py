import sys
input = sys.stdin.readline
arr = input().split('-')
num=[]

for i in arr:
    sum=0
    tmp=i.split('+')
    for j in tmp:
        sum+=int(j)
    num.append(sum)

x = num[0]
for i in range(1, len(num)):
    x -= num[i]
print(x)