import sys
input=sys.stdin.readline


sum=0
result=[]
while True:
    a,b=map(int,input().split())
    sum=sum+b-a
    result.append(sum)
    if b==0:
        break

print(max(result))
