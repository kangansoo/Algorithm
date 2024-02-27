n = int(input())
li=[]

for _ in range(n):
    li.append(list(map(str, input().split())))
for i in range(n):
    li[i][0] = int(li[i][0])
li = sorted(li, key = lambda x:x[0])

for i in range(n):
    print(li[i][0], li[i][1], sep=" ")
print()