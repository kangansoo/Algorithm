a, b, c = map(int, input().split())
result=0

if(a==b and b==c and a==c):
    result=10000+a*1000
elif(a!=b and b!=c and a!=c):
    if(a>b and a>c):
        result=a*100
    elif(b>c and b>c):
        result=b*100
    else:
        result=c*100
else:
    if(a==b):
        result=1000+a*100
    elif(a==c):
        result=1000+a*100
    else:
        result=1000+b*100
print(result)
    