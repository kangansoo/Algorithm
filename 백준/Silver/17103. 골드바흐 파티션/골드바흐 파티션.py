import sys
input=sys.stdin.readline
n=int(input().strip())

li = [False, False] + [True]*999999

for i in range(2, 1000001):
    if li[i]:
        for j in range(i*2, 1000001, i):
            li[j] = False

for _ in range(n):
    count = 0
    num = int(input())
    for i in range(2, num//2+1):
        if li[i] and li[num-i]:
            count += 1
    print(count)