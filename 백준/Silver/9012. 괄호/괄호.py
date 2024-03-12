import sys
input = sys.stdin.readline

n = int(input())
for _ in range(n):
    x=input().strip()

    stack=[]
    for i in x:
        if i == '(':
            stack.append(i)
        else:
            if not stack:
                stack.append(i)
                break
            else:
                stack.pop()
    if len(stack) == 0:
        print('YES')
    else:
        print('NO')