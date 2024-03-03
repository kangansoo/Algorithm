n = int(input())
dic = {}

for i in range(n):
    a, b = input().split()
    dic[a] = b

arr = []
for key, value in dic.items():
    if value == 'enter':
        arr.append(key)

for i in sorted(arr, reverse=True):
    print(i)