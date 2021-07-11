import sys
input=sys.stdin.readline

n=int(input())
li=[]
for _ in range(n):
    t,p=map(int,input().split())
    li.append([t,p])

result=list(map(lambda x:x[1],li))

#print(result)

for i in range(n):
    if i+li[i][0] > n:
        result[i]=0
        continue

    prize=result[i]
    for j in range(i+li[i][0],n):
        if prize+li[j][1] > result[j]:
            result[j]= prize+li[j][1]

print(max(result))