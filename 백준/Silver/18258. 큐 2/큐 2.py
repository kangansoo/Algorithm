import sys
from collections import deque
input = sys.stdin.readline
n = int(input().strip())

d = deque()
for _ in range(n):
    num = list(input().split())
    if num[0] == "push":
        d.append(int(num[1]))
    elif num[0] == "pop":
        if d:
            print(d.popleft())
        else:
            print(-1)
    elif num[0] == "size":
        print(len(d))
    elif num[0] == "empty":
        if d:
            print(0)
        else:
            print(1)
    elif num[0] == "front":
        if d:
            print(d[0])
        else:
            print(-1)
    elif num[0] == "back":
        if d:
            print(d[-1])
        else:
            print(-1)