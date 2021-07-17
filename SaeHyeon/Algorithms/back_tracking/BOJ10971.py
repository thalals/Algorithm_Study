#Problem : https://www.acmicpc.net/problem/10971
#Comment : 다른 사람 코드 보고 참고해서 풀음

import sys
input=sys.stdin.readline

N=int(input())
cost=[list(map(int,input().split())) for i in range(N)]
# 방문한 도시를 추가해주는 리스트
visited=[]
min_value=10**8

def dfs(start,next,value,visited):
    global min_value
    if len(visited)==N:
        if cost[next][start] != 0:
            min_value=min(min_value,value+cost[next][start])
        return
    for i in range(N):
        if cost[next][i] != 0 and i!=start and i not in visited:
            visited.append(i)
            dfs(start,i,value+cost[next][i],visited)
            visited.pop()

for i in range(N):
    dfs(i,i,0,[i])

print(min_value)