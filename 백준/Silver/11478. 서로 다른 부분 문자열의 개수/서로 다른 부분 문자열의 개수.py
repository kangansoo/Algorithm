s = input()
a=set()

for i in range(len(s)):
    for j in range(1,len(s)+1):
        if s[i:j] == '':
            pass
        else:
            a.add(s[i:j])

print(len(a))