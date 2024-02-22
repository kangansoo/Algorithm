n = int(input())

for i in range(1, n+1):
	tmp = list(map(int, str(i)))
	num = sum(tmp) + i
	if num == n:
		print(i)
		break
	if i==n:
		print(0)