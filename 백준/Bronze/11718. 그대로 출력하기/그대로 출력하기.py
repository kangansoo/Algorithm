import sys
data = [sys.stdin.readline() for i in range(100)]

for i in data:
	print(i, end="")
	if not data:
		break