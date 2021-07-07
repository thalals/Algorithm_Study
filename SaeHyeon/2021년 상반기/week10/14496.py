import sys
from collections import deque
input=sys.stdin.readline

before,after=map(int,input().split())
n,m=map(int,input().split())

dic=[[] for _ in range(m+1)]

for i in range(m):
    a,b=map(int,input().split())
    dic[a].append(b)
    dic[b].append(a)

result=[0]*(n+1)
def bfs():
    qu=deque()
    qu.append(before)
    #방문한 거 표시
    result[before]=1
    
    while qu:
        x = qu.popleft()
        if x == after:
            print(result[x]-1)
            return
        for ni in dic[x]:
            if result[ni] == 0:
                qu.append(ni)
                result[ni]= result[x]+1

bfs()
