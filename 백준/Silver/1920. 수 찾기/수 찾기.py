def binarySearch(li, target):
    left=0
    right=len(li)-1
    while left<=right:
        mid = (left+right)//2
        if li[mid] == target:
            return True
        elif target > li[mid]:
            left = mid + 1
        else:
            right = mid -1

n = int(input())
n_li = sorted(list(map(int, input().split())))
m = int(input())
m_li = list(map(int, input().split()))

for i in m_li:
    if binarySearch(n_li, i):
        print(1)
    else:
        print(0)