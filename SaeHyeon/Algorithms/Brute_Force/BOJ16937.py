import sys
input=sys.stdin.readline

h,w=map(int,input().split())
n=int(input())
li=[]

for i in range(n):
    r,c=map(int,input().split())
    if (r*c) <= (h*w):
        li.append([r,c])

print(li)

for i in range(n-1):
    for j in range(i+1,n):
        a1=li[i]
        a2=li[j]
        area=a1[0]*a1[1]+a2[0]+a2[1]
        