num = int(input())
i=2

while i<=num:
	if num%i==0:
		num=num//i
		print(i, sep="\n")
	elif num%i!=0:
		i+=1
	elif num//i==1:
		break