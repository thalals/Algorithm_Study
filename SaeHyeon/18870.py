import sys
input=sys.stdin.readline

n=int(input())
li=list(map(int,input().split()))
result=[]
exp=list(set(li))
exp.sort()
#print(exp)
d={}
for i in range(len(exp)):
    d[exp[i]]=i

for i in li:
    print(d[i],end=" ")

#print(d)
# for i in range(n):
#     result.append(exp.index(li[i]))



