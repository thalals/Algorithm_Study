import sys
input=sys.stdin.readline

N=int(input())
li=[]
for i in range(N):
    a,b=map(int,input().split())
    li.append([a,b])

result=list(map(lambda x:x[1],li))
for i in range(N):
    if i+li[i][0] > N:
        result[i]=0
        continue
    
    prize=result[i]
    for j in range(i+li[i][0],N):
        if prize+li[j][1] > result[j]:
            result[j]=prize+li[j][1]
            

print(max(result))