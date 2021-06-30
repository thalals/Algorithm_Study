#Problem : https://www.acmicpc.net/problem/1158
#Comment : 결과는 맞게 나왔는데 틀림, 나중에 다시 풀어보기

import sys
input=sys.stdin.readline

n,m=map(int,input().split())

poketmon=dict()
for i in range(n):
    a=input().rstrip()
    poketmon[str(i+1)]=a
    poketmon[a]=str(i+1)

for j in range(m):
    s=input().rstrip()
    print(poketmon[s])