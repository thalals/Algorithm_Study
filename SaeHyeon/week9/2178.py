import sys
input=sys.stdin.readline

dx=[1,-1,0,0]
dy=[0,0,-1,1]

n,m=map(int,input().split())
li=[]
for i in range(n):
    li.append(list(input().rstrip()))
queue=[]
cnt=1
visit=[[0]*m for _ in range(n)]
visit[0][0]=1

queue.append([0,0])


while queue:
    x,y=queue[0][0],queue[0][1]
    queue.pop()

    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]

        if 0<=nx<n and 0<=ny<m:
            if li[nx][ny]=="1" and visit[nx][ny]==0:
                queue.append([nx,ny])
                visit[nx][ny]=1
                cnt+=1

print(cnt)

