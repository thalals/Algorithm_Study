dx=[-1,0,1,0]
dy=[0,1,0,-1]

n=int(input())
a=[list(input()) for _ in range(n)]

cnt=0
matrix=[]

def dfs(x,y):
    global cnt
    a[x][y] = '0' #체크한 곳은 0
    cnt+=1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or nx >= n or ny < 0 or ny >=n:
            continue
        if a[nx][ny] == '1':
            dfs(nx,ny)


for i in range(n):
    for j in range(n):
        if a[i][j] == '1':
            cnt= 0
            dfs(i,j)
            matrix.append(cnt)

print(len(matrix))
matrix.sort()
for i in matrix:
    print(i)