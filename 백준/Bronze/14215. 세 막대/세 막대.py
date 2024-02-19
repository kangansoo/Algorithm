li = list(map(int, input().split()))

x=max(li)
li.remove(x)

if x >= sum(li):
	x=sum(li)-1
	print(x+sum(li))
else:
	print(x+sum(li))