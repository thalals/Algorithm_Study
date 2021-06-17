import sys
input=sys.stdin.readline

n=int(input())
li=[]
for i in range(n):
    a,b=map(int,input().split())
    li.append([a,b])

for i in li:
    key=1
    for j in li:
        if i[0] <j[0] and i[1] <j[1]:
            key+=1
    print(key, end=" ")


