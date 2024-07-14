import sys
input = sys.stdin.readline

n = int(input())
# a = [[] for _ in range(n)]
# b = [[] for _ in range(n)]

for i in range(n):
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    dict_a = {x:0 for x in range(1, 5)}
    dict_b = {x:0 for x in range(1, 5)}
    for i in a[1:]:
        dict_a[i] += 1
    for i in b[1:]:
        dict_b[i] += 1
    if dict_a[4] > dict_b[4]:
        print('A')
    elif dict_a[4] < dict_b[4]:
        print('B')
    elif dict_a[3] > dict_b[3]:
        print('A')
    elif dict_a[3] < dict_b[3]:
        print('B')
    elif dict_a[2] > dict_b[2]:
        print('A')
    elif dict_a[2] < dict_b[2]:
        print('B')
    elif dict_a[1] > dict_b[1]:
        print('A')
    elif dict_a[1] > dict_b[1]:
        print('B')
    else:
        print('D')


