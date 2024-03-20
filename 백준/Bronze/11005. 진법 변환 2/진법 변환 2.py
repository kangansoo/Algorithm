import sys
input = sys.stdin.readline

n, b = map(int, input().split())
li="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
answer =""

while n!=0:
    answer += li[n%b]
    n //= b
print(answer[::-1])