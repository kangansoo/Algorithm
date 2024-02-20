a, b, c, d, e, f = map(int, input().split())
x=[]
y=[]

for i in range(-999, 1000):
	for j in range(-999, 1000):
		if a*i + b*j == c:
			x.append(i)
			y.append(j)

for i in range(len(x)):
	if d*x[i] + e*y[i] == f:
		print(x[i], y[i], sep=" ")