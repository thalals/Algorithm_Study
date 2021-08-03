import sys
input=sys.stdin.readline

bingo={}
visit=[[False]*5 for _ in range(5)]
for i in range(5):
    arr=list(map(int,input().split()))

    for j in range(len(arr)):
        bingo[arr[j]]=[i,j]

def check():
    # 가로 줄
    great=0
    for i in range(5):
        cnt=0
        for j in range(5):
            if visit[i][j]==True:
                cnt+=1
        if cnt==5:
            great+=1
            if great >=3:
                return 1

    for j in range(5):
        cnt=0
        for i in range(5):
            if visit[i][j]==True:
                cnt+=1
        if cnt==5:
            great+=1
            if great >=3:
                return 1

    for i in range(5):
        cnt=0
        if visit[i][i]==True:
            cnt+=1
        if cnt==5:
            great+=1
            if great >=3:
                return 1     
    
    for i in range(5):
        cnt=0
        if visit[i][4-i]==True:
            cnt+=1
        if cnt==5:
            great+=1
            if great >=3:
                return 1

cnt=0
for _ in range(5):
    arr=list(map(int,input().split()))
    for i in range(len(arr)):
        if arr[i] in bingo.keys():
            a,b=bingo[arr[i]]
            visit[a][b]=True
            if check():
                print(cnt*5+i+1)
                break
    cnt+=1

