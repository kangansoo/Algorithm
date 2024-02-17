while True:
    n = int(input())
    li = []
    i=1
    if n == -1:
        break
    
    while i<n:
        if n%i==0:
            li.append(i)
            i+=1
        else:
            i+=1
    if sum(li)==n:
        print(f"{n} = ", end="")
        print(*li, sep=" + ")
    else:
        print(f"{n} is NOT perfect.")