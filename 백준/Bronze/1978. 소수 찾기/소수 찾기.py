cnt = int(input())
li = list(map(int, input().split()))

def func(x):
    if x <2:
        return False
    for i in range(2, x):
        if x%i==0:
            return False
    return True

for j in li:
    if func(j):
        continue
    else:
        cnt -= 1     
    
print(cnt)