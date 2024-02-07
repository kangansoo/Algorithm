data = [list(' '.join(input()).split()) for _ in range(5)]

for i in range(15):
	for j in range(15):
		try:
			print(data[j][i], end="")
		except:
			pass