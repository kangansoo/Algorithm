import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
q = deque()

for _ in range(n):
    num = list(map(int, input().split()))
    if num[0] == 1:
        q.appendleft(num[1])
    elif num[0] == 2:
        q.append(num[1])
    elif num[0] == 3:
        if q:
            print(q.popleft())
        else:
            print(-1)
    elif num[0] == 4:
        if q:
            print(q.pop())
        else:
            print(-1)
    elif num[0] == 5:
        print(len(q))
    elif num[0] == 6:
        if q:
            print(0)
        else:
            print(1)
    elif num[0] == 7:
        if q:
            print(q[0])
        else:
            print(-1)
    elif num[0] == 8:
        if q:
            print(q[-1])
        else:
            print(-1)


    