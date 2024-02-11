h, m = map(int, input().split())
plus = int(input())
h=h+plus//60
m=m+plus%60

if(m>=60):
    m-=60
    h+=1
if(h>=24):
    h-=24
    
print(h, m)