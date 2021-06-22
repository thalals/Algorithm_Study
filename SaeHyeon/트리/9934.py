import sys
input=sys.stdin.readline

k=int(input())
node=list(map(int,input().split()))

result=[[] for _ in range(k)]
print(result)
temp=[]
for i in range(len(node)):
    if (i%2)==0:
        result[k-1].append(node[i])
    if (i%2)!=0:
        result[k-2].append(node[i])

if len(result[1]) == 3:
    result[0].append(result[1].pop(1))

for i in range(k):
    for j in result[i]:
        print(j,end=' ')
    print()