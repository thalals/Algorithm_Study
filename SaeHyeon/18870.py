import sys
from bisect import bisect_right,bisect_left
input=sys.stdin.readline

n=int(input())
li=list(map(int,input().split()))
result=[]
exp=list(set(li))
exp.sort()
d={}

for i in range(len(exp)):
    d[exp[i]]=i

for i in li:
    print(d[i],end=" ")