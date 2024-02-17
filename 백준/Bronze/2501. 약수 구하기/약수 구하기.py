n, k = map(int, input().split())
li = []

i=1
while i<=n:
    if n%i==0:
        li.append(i)
        i+=1
    else:
        i+=1
if(k>len(li)):
    print(0)
else:
    print(li[k-1])