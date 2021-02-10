import sys
input=sys.stdin.readline

N=int(input())

for i in range(1,N+1):
    li=list(map(int,str(i)))
    result=i+sum(li)
    if result == N:
        print(i)
        break
