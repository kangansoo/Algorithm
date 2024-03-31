import sys
input = sys.stdin.readline

n = int(input().strip())
li = list(map(int, input().split()))
li.sort()

answer=0
for i in range(n):
    for j in range(0, i+1):
        answer+=li[j]
print(answer)