import sys
input=sys.stdin.readline

N,M=map(int,input().split())
bulb=list(map(int,input().split()))

for _ in range(M):
    a,b,c=map(int,input().split())
    if a==1:
        bulb[b-1]=c
    elif a==2:
        for i in range(b-1,c):
            if bulb[i]==0:
                bulb[i]=1
            else:
                bulb[i]=0
    elif a==3:
        for i in range(b-1,c):
            bulb[i]=0
    elif a==4:
        for i in range(b-1,c):
            bulb[i]=1

print(*bulb)