n, b = input().split()
b = int(b)

al = list('0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ')
num = [i for i in range(36)]

sum = 0
for i, v in enumerate(n):
	idx = al.index(v)
	sum += num[idx]*(b**(len(n)-1-i))
print(sum)