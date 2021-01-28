import sys
input=sys.stdin.readline

n=int(input())
li=[]
for i in range(n):
    x,y=map(int,input().split())
    li.append([x,y])

li.sort()
for i in range(n):
    print(li[i][0], li[i][1])