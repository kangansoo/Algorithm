num = int(input())
line = 1

while num > line:
    num -= line
    line += 1

if line % 2 == 0:
    n = num
    m = line - num + 1
else:
    n = line - num + 1
    m = num
print(f'{n}/{m}')