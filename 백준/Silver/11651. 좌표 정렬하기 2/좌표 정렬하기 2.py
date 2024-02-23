n = int(input())
li= [list(map(int, input().split())) for _ in range(n)]
li = sorted(li, key = lambda  x:(x[1], x[0]))

for i in li:
	print(i[0], i[1], sep=" ")
print()