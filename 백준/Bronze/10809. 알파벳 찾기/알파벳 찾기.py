str = input()
data = []
result = []
for i in range(len(str)):
	data.append(str[i])

for j in range(97, 123):
	if chr(j) in data:
		result.append(data.index(chr(j)))
	else:
		result.append(-1)

for x in result:
	print(x, end = " ")