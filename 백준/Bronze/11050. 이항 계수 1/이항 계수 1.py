import sys
input = sys.stdin.readline

def fac(x):
    if x == 1 or x == 0:
        return 1
    return x * fac(x-1)

n, k = map(int, input().split())

print(fac(n)//(fac(n-k)*fac(k)))