import sys
from bisect import bisect_right,bisect_left
input=sys.stdin.readline

n=int(input())
li=list(map(int,input().split()))
exp=list(set(li))
exp.sort()

for i in range(n):
    print(bisect_left(exp,li[i]),end= ' ')
