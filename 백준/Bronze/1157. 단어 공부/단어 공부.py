word = input().upper()
word_list = list(set(word))
li = []

for i in word_list:
    cnt = word.count(i)
    li.append(cnt)

if li.count(max(li))>=2:
    print("?")
else:
    print(word_list[li.index(max(li))])