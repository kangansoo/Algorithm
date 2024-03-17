import sys
input = sys.stdin.readline
n = int(input())
li = list(map(int, input().split()))

if n != 1:
    print(min(li)*max(li))
else:
    print(li[0]**2)