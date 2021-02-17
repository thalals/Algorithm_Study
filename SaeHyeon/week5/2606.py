import sys
input=sys.stdin.readline

n=int(input())
v=int(input())
li=[[0] * n for i in range(n)]
visit=[0 for i in range(n)]

def dfs(i):
    visit[i]=1
    for j in range(n):
        if li[i][j] == 1 and visit[j] == 0:
            dfs(j)

# 간선 연결된거 1로 표시
for i in range(v):
    f,s=map(int,input().split())
    li[f-1][s-1] = 1
    li[s-1][f-1] = 1

dfs(0)
cnt=0
for i in range(1,n):
    if visit[i] == 1:
        cnt+=1
print(cnt)