n = int(input())
li = list(map(int, input().split()))
s_li = sorted(set(li))

dic={}
for i in range(len(s_li)):
    dic[s_li[i]] = i
    
for i in li:
    print(dic[i], end=" ")