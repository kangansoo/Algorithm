n = int(input())
cnt = n

for i in range(n):
	data = input()
	for j in range(len(data)-1):
		if data[j]==data[j+1]:
			pass
		elif data[j] in data[j+2:]:
			cnt-=1
			break
print(cnt)