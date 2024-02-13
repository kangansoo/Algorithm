data = list(int(input()) for _ in range(28))
result=[]

for i in range(1, 31):
	if i not in data:
		result.append(i)
	
result = sorted(result)
print(result[0], result[1], end=" ")