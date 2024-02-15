n = int(input())

for i in range(n):
	result = []
	m = int(input())
	if(m//25>=0):
		result.append(str(m//25))
		tmp = m%25
		if(tmp//10>=0):
			result.append(str(tmp//10))
			tmp = tmp%10
			if(tmp//5>=0):
				result.append(str(tmp//5))
				tmp = tmp%5
				result.append(str(tmp//1))
			else:
				result.append('0')
				result.append(str(tmp//1))
		else:
			result.append('0')
	else:
		result.append('0')
	for i in result:
		print(i, end=" ")
	print()