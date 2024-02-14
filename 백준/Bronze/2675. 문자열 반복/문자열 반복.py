n = int(input())

def func(x, y):
  for i in x:
    for j in range(y):
      print(i, end="")
  print()

for i in range(n):
	a, b = list(input().split())
	func(b, int(a))