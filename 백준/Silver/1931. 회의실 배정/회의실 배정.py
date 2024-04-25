import sys
input = sys.stdin.readline

n = int(input())
li=[]

for _ in range(n):
    li.append(list(map(int, input().split())))
li.sort(key=lambda x : (x[1], x[0]))

endTime = 0
cnt=0

for i in li:
    if i[0] >= endTime:
        endTime = i[1]
        cnt+=1

print(cnt)