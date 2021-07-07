import sys
input=sys.stdin.readline

n=int(input())
li=[]

for i in range(n):
    li.append(list(map(int,input().rstrip())))
print(li)
def dfs(li,y,x,cnt):
    li[y][x] = 0
    cnt+=1
    dx=[1,-1,0,0]
    dy=[0,0,-1,1]   

    for i in range(4):
        ny=y+dy[i]
        nx=x+dx[i]

        if nx>=0 and nx<n and ny>=0 and ny < n:
            if li[ny][nx]==1:
                dfs(li,ny,nx,cnt)
                
    return cnt

cnt_li=[]
for i in range(n):
    for j in range(n):
        if li[i][j] ==1:
            cnt_li.append(dfs(li,i,j,1))

print(len(cnt_li))
cnt_li.sort()
for i in range(len(cnt_li)):
    print(cnt_li[i])
