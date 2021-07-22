import sys
input=sys.stdin.readline

N,M=map(int,input().split())
namu=[]
for _ in range(M):
    namu.append(list(map(int,input().split())))
visit=[[False]*M for _ in range(N)]
max_result=0
def dfs(y,x,value):
    global max_result
    
    if x==M:
        x=0
        y+=1
    if y==N:
        return
    if y+1<N and x+1<M and not visit[y+1][x] and not visit[y][x+1]:
        visit[y][x]=True
        visit[y+1][x]=True
        visit[y][x+1]=True
        value=(namu[y][x]*2)+namu[y+1][x]+namu[y][x+1]
        max_result=max(max_result,value)
        dfs(y,x+1,max_result)
        visit[y][x]=False
        visit[y+1][x]=False
        visit[y][x+1]=False
        
dfs(0,0,0)
print(max_result)