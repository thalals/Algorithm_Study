import sys
from itertools import combinations
input=sys.stdin.readline

N,S=map(int,input().split())
arr=list(map(int,input().split()))

cnt=0

# for i in range(1,N+1):
#     for asd in combinations(arr,i):
#         if sum(asd) == S:
#             cnt+=1

# print(cnt)

# 백트래킹
def dfs(idx,result):
    global cnt
    if idx>=N:
        return
    result+=arr[idx]
    if result == S:
        cnt+=1
    dfs(idx+1,result-arr[idx])
    dfs(idx+1,result)
dfs(0,0)
print(cnt)