import sys
n = int(sys.stdin.readline())

def recursion(x, i, j):
    if i>=j:
        return 1, i+1
    elif x[i] != x[j]:
        return 0, i+1
    else:
        return recursion(x, i+1, j-1)

def ispel(x):
    return recursion(x, 0, len(x)-1)

for _ in range(n):
    str = sys.stdin.readline().strip()
    print(ispel(str)[0], ispel(str)[1], sep=" ")