# d의 값이 0이면 북쪽, 1이면 동쪽, 2이면 남쪽, 3이면 서쪽
# d==0이면 (0,1), d==1이면 (1,0), d==2이면 (0,-1), d==3이면 (-1,0)

#로봇청소기가 할것은 
# 1. 현 위치 청소 -- 방문 배열 1로 표시
# 2. 청소기의 방향에서 왼쪽 공간에 청소를 하지 않았다. 방문한 공간 표시해야할듯
# 3. 왼쪽 방향에 청소할 공간이 없다. 그 방향으로 회전하고 왼쪽 탐색 다시 진행
# 4. 네방향 청소 완료 및 벽이면 방향은 유지, 한칸 뒤로 후진 후 왼쪽 탐색 다시 진행
# 5. 네 방향 청소 완료 및 벽이고 뒤도 벽이면 끝

import sys
input=sys.stdin.readline
 
dr=[-1,0,1,0]
dc=[0,1,0,-1]

def robot_clean(array,r,c,d,n,m):
    result=0

    for _ in range(4):
        nd=(d+3)%4
        nr=r+dr[nd]
        nc=c+dc[nd]

        if 0<=nr<n and 0<=nc<m and array[nr][nc]==0:
            array[nr][nc]=2
            result+=1
            break
    # array[r][c]==2

    # while(True):
    #     nd=d
    #     for i in range(4):
    #         value=False
    #         nd=(d+3)%4
    #         nr=r+dx[nd]
    #         nc=c+dy[nd]

    #         if 0<=nr<n and 0<=nc<m and array[nr][nc]==0:
    #             result+=1
    #             array[nr][nc]=2
    #             r=nr
    #             c=nc
    #             value=True
    #             break

    #         if value==False:
    #             d=(d+2)%4
    #             r=r+dx[d]
    #             c=c+dy[d]
    #             if array[r][c]==1:
    #                 break
    # return result

    

def main():
    n,m=map(int,input().split())
    r,c,d=map(int,input().split())
    field=[]
    value=0
    for i in range(m):
        field.append(list(map(int,input().split())))

    value=robot_clean(field,r,c,d,n,m)
    print(value)
main()