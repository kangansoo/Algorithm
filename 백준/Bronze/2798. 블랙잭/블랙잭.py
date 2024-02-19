n, m = map(int, input().split())
li = list(map(int, input().split()))
result=0

for a in range(n-2):
	for b in range(a+1, n-1):
		for c in range(b+1, n):
			if li[a]+li[b]+li[c] > m:
				continue
			elif li[a]+li[b]+li[c]>result:
				result = li[a]+li[b]+li[c]
print(result)