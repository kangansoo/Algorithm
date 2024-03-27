import sys
input = sys.stdin.readline
n = int(input().strip())
li = list(map(int, input().split()))
stack = []

num=1
for i in li:
    stack.append(i)
    while stack and stack[-1] == num:
        stack.pop()
        num+=1

if stack:
    print('Sad')
else:
    print('Nice')