import sys
input = sys.stdin.readline
stack=[]

n = int(input())
for _ in range(n):
    m=int(input())
    if m == 0 :
        stack.pop()
    else:
        stack.append(m)
print(sum(stack))