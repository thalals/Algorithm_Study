import sys
from itertools import combinations
input=sys.stdin.readline

N,S=map(int,input().split())
arr=list(map(int,input().split()))

cnt=0

for i in range(1,N+1):
    for asd in combinations(arr,i):
        if sum(asd) == S:
            cnt+=1

print(cnt)