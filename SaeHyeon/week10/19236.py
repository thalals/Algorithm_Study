import sys
input=sys.stdin.readline

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, -1, -1, -1, 0, 1, 1, 1]

fishmap=[[0]*4 for _ in range(4)]
dirt=[[0]*4 for _ in range(4)]

for j in range(4):
    fish=list(map(int,input().split()))
    for i in range(len(fish)):
        if (i%2)==0:
            fishmap[j][i//2]=fish[i]
        elif (i%2)==1:
            dirt[j][i//2]=fish[i]

print(fishmap)
print(dirt)

def fish_find(arr,num):
    for i in range(4):
        for j in range(4):
            if arr[i][j] == num:
                return i,j

def fish_move(arr,dddd,shark_x,shark_y):
    for i in range(1,17):
        print(i)
        a,b=fish_find(arr,i)
        root=(dddd[a][b]-1)%8 
        print(a,b,root)
        # dirt 인덱스 방향으로 배열 이동
        for j in range(8):
            na,nb=a+dx[root],b+dy[root]
            print(na,nb)
            #양식장 못넘어가게
            if 0<=na<4 and 0<=nb<4:
                if na != shark_x and nb != shark_y:
                    print("arr[a][b]",arr[a][b],"arr[na][nb]",arr[na][nb])
                    print("바뀌기 전",arr)
                    arr[a][b],arr[na][nb]==arr[na][nb],arr[a][b]
                    print("바뀌기 후",arr)
                    dddd[a][b],dddd[na][nb]==dddd[na][nb],root
                    break
            root=(root+1)%8

fish_move(fishmap,dirt,0,0)

print(fishmap)
print(dirt)