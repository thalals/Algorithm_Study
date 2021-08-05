import sys
input=sys.stdin.readline

N=int(input())
position=[[0]*N for _ in range(N)]
students={}
for i in range(1,N**2+1):
    students[i]=0

arr=[list(map(int,input().split())) for _ in range(N**2)]

for i in arr:
    students[i[0]]=i[1:]

dy=[1,0,0,-1]
dx=[0,-1,1,0]

def check(idx):
    global dy,dx,position,students,N
    max_friends=-1
    max_empty=-1

    cur_y=-1
    cur_x=-1
    for i in range(N-1,-1,-1):
        for j in range(N-1,-1,-1):
            rec_empty=0
            rec_friends=0
            if position[i][j]==0:
                for k in range(4):
                    ny=i+dy[k]
                    nx=i+dx[k]
                    if 0<=ny <N and 0<=nx<N:
                        if position[ny][nx]==0:
                            rec_empty+=1
                        elif position[ny][nx] in students[idx]:
                            rec_friends+=1
                
    return cur_y,cur_x

for i in arr:
    y,x=check(i[0])
    position[y][x]=i[0]
    break

for i in range(N):
    for j in range(N):
        print(position[i][j],end=' ')
    print()

