x, y, w, h = map(int, input().split())

print(min(min(w-x, abs(0-x)), min(h-y, abs(0-y))))