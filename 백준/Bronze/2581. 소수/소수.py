m = int(input())
n = int(input())

def func(x):
    if x <2:
        return False
    for i in range(2, x):
        if x%i==0:
            return False
    return True

li=[]
for j in range(m, n+1):
    if func(j):
        li.append(j) 
        
if(len(li)>0):
    print(sum(li))
    print(li[0])
else:
    print(-1)