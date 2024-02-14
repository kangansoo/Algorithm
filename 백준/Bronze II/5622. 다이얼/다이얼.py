n = input()
data = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']
str = []
result = 0

for k in n:
	str.append(k)

for i in data:
	for j in str:	
		if j in i:
			result+=data.index(i)+2
print(result+len(n))