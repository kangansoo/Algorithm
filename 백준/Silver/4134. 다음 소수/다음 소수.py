import sys
input = sys.stdin.readline
n = int(input().strip())

def ex(x):
    if x <= 1:
        return False
    for i in range(2, int(x**0.5) + 1):
        if x % i == 0:
            return False
    return True
            
def exx(x):
    while True:
        if ex(x):
            return x
        x+=1

for _ in range(n):
    x = int(input().strip())
    print(exx(x))