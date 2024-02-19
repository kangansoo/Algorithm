n = int(input())
i, cnt = 1, 1

while n>i:
	i += cnt*6
	cnt += 1
print(cnt)