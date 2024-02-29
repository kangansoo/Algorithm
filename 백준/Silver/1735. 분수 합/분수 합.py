m, n = map(int, input().split())
x, y = map(int, input().split())

def gcd(a, b):
    if b==0:
        return a
    else:
        return gcd(b, a%b)

def lcm(a, b):
    return int(a*b/gcd(a,b))

def mol(a, b, c, d):
    return int(a*d/gcd(b,d))+int(b*c/gcd(b,d))
         
print(mol(m, n, x, y)//gcd(mol(m, n, x, y), lcm(n, y)), lcm(n, y)//gcd(mol(m, n, x, y), lcm(n, y)), sep=" ")
