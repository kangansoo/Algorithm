import sys
from collections import deque

input = sys.stdin.readline
n = int(input().strip())

cc = set()
for _ in range(n):
    a, b = input().split()
    if a == 'ChongChong' or b == 'ChongChong':
        cc.add(a)
        cc.add(b)
    if a in cc or b in cc:
        cc.add(a)
        cc.add(b)
print(len(cc))