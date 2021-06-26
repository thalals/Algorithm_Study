#Problem : https://www.acmicpc.net/problem/14425
#Comment : 해결

import sys
input=sys.stdin.readline

n,m=map(int,input().split())
s={}
for i in range(n):
    a=input().rstrip()
    s[a]=0

cnt=0
for j in range(m):
    t=input().rstrip()
    if t in s.keys():
        s[t]+=1

for key,value in s.items():
    cnt+=value

print(cnt)