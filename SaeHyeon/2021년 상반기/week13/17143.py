import sys
input=sys.stdin.readline

#낚시꾼 이동하고 잡고
#상어가 이동하고
#상어 크기가 큰놈이 작은 놈 잡아먹고

#낚시꾼 위치
#상어관리
#크기 비교 및 삭제

dx=[-1,1,0,0]
dy=[0,0,1,-1]

def fish_man(x):
    x+=1
    for i in range(r):
        if fish_map[i][x] != 0:
            size=fish_map[i][x]
            fish_map[i][x]=0
    
    for i in range(len(shark)):
        if size == shark[i][4]:
            shark[i][4]=0
    
    return size

#상어가 움직여야해요
def shark_move():
    for i in range(m):
        if shark[i][4] != 0:
            if shark[i][2]==0:
                continue
            else:
                nx,ny= shark[i][0]-1,shark[i][1]-1
                0 2 -> 1 2
                1 3 -> 1 5 -5
                a=nx+(dy[shark[i][3]-1]*shark[i][2])
                b=ny+(dx[shark[i][3]-1]*shark[i][2])
                if a > r:
                    a-=r
            
fishMan=(-1)
result=0
r,c,m=map(int,input().split())
fish_map=[[0]*c for _ in range(r)]
shark=[]
#print(fish_map)
for i in range(m):
    shark.append(list(map(int,input().split())))

for i in range(m):
    fish_map[shark[i][0]-1][shark[i][1]-1]=shark[i][4]


result+=fish_man(fishMan)

for i in range(len(shark)):
    print(shark[i])


for i in range(len(fish_map)):
    print(fish_map[i])

print(result)