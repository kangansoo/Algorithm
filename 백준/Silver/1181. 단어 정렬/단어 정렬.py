n = int(input())
li= [input() for _ in range(n)]
li = list(set(li))
li = sorted(li)
li = sorted(li, key=len)

for i in li:
	print(i)