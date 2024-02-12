n = int(input())
data = list(map(int, input().split()))
x = int(input())
cnt=0

for i in data:
	if i==x:
		cnt+=1
	else:
		continue

print(cnt)