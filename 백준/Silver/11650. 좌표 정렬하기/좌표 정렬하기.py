n = int(input())
li= [list(map(int, input().split())) for _ in range(n)]

for i in sorted(li):
	print(i[0], i[1], sep=" ")
print()