data = list(int(input()) for _ in range(9))
max = data[0]

for i in range(1, 9):
    if(data[i]>max):
        max=data[i]
print(max)
print(data.index(max)+1)