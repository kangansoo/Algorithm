while True:
	li = sorted(list(map(int, input().split())))
	if sum(li)==0:
		break
	# print(li)
	if li[2] >=li[0]+li[1]:
		print("Invalid")
	else:
		# print("a")
		if li[0]==li[1] and li[0]==li[2] and li[2]==li[1]:
			print("Equilateral")
		elif li[0]!=li[1] and li[0]!=li[2] and li[2]!=li[1]:
			print("Scalene")
		else:
			print("Isosceles")