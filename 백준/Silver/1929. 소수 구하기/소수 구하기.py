import sys
input = sys.stdin.readline
a, b = map(int, input().split())

def func(x):
    for i in range(2, int(x**0.5)+1):
        if x%i == 0:
            return False
    return True
if a == 1:
    for i in range(2, b+1):
        if func(i):
            print(i)
else:
    for i in range(a, b+1):
        if func(i):
            print(i)