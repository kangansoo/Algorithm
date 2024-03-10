import sys
input = sys.stdin.readline

def gcd(a, b):
    if b==0:
        return a
    else:
        return gcd(b, a%b)

n = int(input())
li = [int(input()) for _ in range(n)]
gaps = []

for i in range(1, n):
    gaps.append(li[i] - li[i-1])

g = gaps[0]
for i in range(1, len(gaps)):
    g = gcd(g, gaps[i])

answer= 0
for i in gaps:
    answer+=i//g-1
print(answer)