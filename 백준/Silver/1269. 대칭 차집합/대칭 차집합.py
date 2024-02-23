n, m = map(int, input().split())
a=set(map(int, input().split()))
b=set(map(int, input().split()))
c, d = a-b, b-a

print(len(c)+len(d))