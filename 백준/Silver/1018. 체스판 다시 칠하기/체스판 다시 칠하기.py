n, m = map(int, input().split())
arr = [list(input()) for _ in range(n)]
result=[]

for i in range(n-7):
	for j in range(m-7):
		cnt_w = 0
		cnt_b = 0
		for a in range(i, i+8):
			for b in range(j, j+8):
				if (a + b) % 2 == 0:
					if arr[a][b] != 'B':
						cnt_w += 1
					if arr[a][b] != 'W':
						cnt_b += 1
				else:
					if arr[a][b] != 'W':
						cnt_w += 1
					if arr[a][b] != 'B':
						cnt_b += 1
		result.append(cnt_w)
		result.append(cnt_b)

print(min(result))