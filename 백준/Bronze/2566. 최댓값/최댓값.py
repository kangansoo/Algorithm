data = [list(map(int, input().split())) for _ in range(9)]
tmp=[]

for i in range(9):
  for j in range(9):
    a = max(data[i])
 
  tmp.append(a)
b=tmp.index(max(tmp))
c=data[b].index(max(data[b]))
print(data[b][c])
print(b+1, c+1, end=" ")