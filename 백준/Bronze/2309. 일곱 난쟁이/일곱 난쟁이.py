import sys
input = sys.stdin.readline
arr = []
answer = []

for _ in range(9):
    arr.append(int(input()))

def backtracking():
    if len(answer) == 7 and sum(answer) == 100:
        print(*sorted(answer), sep="\n")
        return True
    for i in range(9):
        if visited[i]:
            continue
        visited[i] = True
        answer.append(arr[i])
        if backtracking():
            return True
        answer.pop()
        visited[i] = False

visited = [False] * 9

backtracking()
