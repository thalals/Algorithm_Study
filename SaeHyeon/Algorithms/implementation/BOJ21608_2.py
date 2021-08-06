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
            if (position[i][j]==0):
                for k in range(4):
                    ny=i+dy[k]
                    nx=j+dx[k]
                    if ny<0 or nx<0 or ny>=N or nx>=N:
                        continue
                    # 비어있는 칸 찾기
                    if (position[ny][nx]==0):
                        rec_empty+=1
                    # 인접한 칸 중에서 좋아하는 학생 찾기
                    elif (position[ny][nx] in students[idx]):
                        rec_friends+=1
                # 인접한 친구가 많으면
                if (rec_friends>=max_friends):
                    # 인접한 친구가 많은 칸들이 다수일떄
                    if (rec_friends==max_friends):
                        # 비어있는 칸이 많을때
                        if (rec_empty>=max_empty):
                            cur_y=i
                            cur_x=j
                            max_friends=rec_friends
                            max_empty=rec_empty
                    # 인접한 친구가 많은 칸이 하나일떄
                    else:
                        cur_y=i
                        cur_x=j
                        max_friends=rec_friends
                        max_empty=rec_empty
                    
    return cur_y,cur_x                


for i in arr:
    y,x=check(i[0])
    position[y][x]=i[0]

satisfaction=0
for i in range(N):
    for j in range(N):
        cnt=0
        li=students[position[i][j]]
        for k in range(4):
            ny=i+dy[k]
            nx=j+dx[k]
            if ny<0 or nx<0 or ny>=N or nx>=N:
                continue
            for z in range(len(li)):
                if position[ny][nx]==li[z]:
                    cnt+=1
        if cnt==0:
            continue
        elif cnt==1:
            satisfaction+=1
        elif cnt==2:
            satisfaction+=10
        elif cnt==3:
            satisfaction+=100
        else:
            satisfaction+=1000
print(satisfaction)