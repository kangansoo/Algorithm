n = int(input())
li = list(map(int, input().split()))
m = int(input())
li2 = list(map(int, input().split()))
dic = {}

for i in li:    
    if i in dic:
        dic[i] += 1
    else:
        dic[i] = 1

result = []
for m in li2:
    if m in dic:
        result.append(str(dic[m]))
    else:
        result.append('0')

print(' '.join(result))