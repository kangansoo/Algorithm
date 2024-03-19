import sys
from collections import deque

input = sys.stdin.readline
n=int(input())
d=deque(enumerate(list(map(int,input().split()))))
li=[]

for _ in range(n):
    idx, num = d.popleft()
    li.append(idx+1)
    if num>0:
        d.rotate(-(num-1))
    else:
        d.rotate(-num)
print(*li)