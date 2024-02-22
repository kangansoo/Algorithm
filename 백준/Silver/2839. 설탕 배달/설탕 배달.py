n = int(input())
a, b = 5, 3
cnt = []

for i in range(n//a+1):
	for j in range(n//b+1):
		if i*a + j*b == n:
			cnt.append(i+j)
		
if len(cnt)==0:
	print(-1)
else:
	min = cnt[0]
	for k in cnt:
		if k < min:
			min = k
	print(min)