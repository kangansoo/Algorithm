import sys
input = sys.stdin.readline

while True:
    stack=[]
    str = input().rstrip()
    if str=='.':
        break
    for i in str:
        if i=='(' or i=='[':
            stack.append(i)
        elif i==')':
            if not stack or stack[-1]!='(':
                stack.append(i)
                break
            else:
                stack.pop()
        elif i==']':
            if not stack or stack[-1]!='[':
                stack.append(i)
                break
            else:
                stack.pop()
    if len(stack) == 0:
        print('yes')
    else:
        print('no')