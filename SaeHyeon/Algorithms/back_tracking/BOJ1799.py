# 문제 : 백준 1799
# 내용 : 답은 나왔으나 시간 초과 나옴
import sys
input=sys.stdin.readline

N=int(input())
chess=[]
for _ in range(N):
    chess.append(list(map(int,input().split())))

visit=[[False]*N for _ in range(N)]
max_result=0
# 비숍이 놓일 수 있는지 없는지 체크하는 함수
# 0을 리턴하면 비숍을 놓을 수 없음 1을 리턴하면 가능

# 좌하향 대각선이랑 우하향 대각선의 visit을 따로 함
def checking(y,x):
    for i in range(N):
        # 왼쪽 아래
        if y+i <N and x+i<N:
            if visit[y+i][x+i]==True:
                return 0
        # 왼쪽 위
        if y-i >=0 and x+i<N:
            if visit[y-i][x+i]==True:
                return 0
        # 오른쪽 아래
        if y+i<0 and x-i>=0:
            if visit[y+i][x-i]==True:
                return 0
        # 오른쪽 위
        if y-i>=0 and x-i>=0:
            if visit[y-i][x-i]==True:
                return 0
        
    return 1

# 백 트래킹 함수
def backtracking(y,x,cnt):
    global max_result

    if x==N:
        x=0
        y+=1
    if y==N:
        max_result=max(max_result,cnt)
        return

    if chess[y][x]==1:
        if checking(y,x)==1:
            visit[y][x]=True
            backtracking(y,x+1,cnt+1)
            visit[y][x]=False
    backtracking(y,x+1,cnt)

backtracking(0,0,0)
print(max_result)

