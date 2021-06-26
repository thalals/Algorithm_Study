import sys
input=sys.stdin.readline

arr=[]
n=int(input())

for i in range(n):
    a=int(input())
    if a == 0:
        if len(arr) == 0:
            print(0)
            continue
        max_value=max(arr)
        print(arr.pop(arr.index(max_value)))
    else:
        arr.append(a)

