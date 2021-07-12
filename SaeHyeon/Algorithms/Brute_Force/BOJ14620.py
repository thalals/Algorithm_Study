import sys
input=sys.stdin.readline

dx=[0,0,-1,0,1]
dy=[0,1,0,-1,0]

n=int(input())
gold=[]
visit=[[0]*n for _ in range(n)]
result=9999
for _ in range(n):
    gold.append(list(map(int,input().split())))

# print(gold)
# print(visit)
cnt=0

def check(x,y):
    global n
    for i in range(5):
        nx=x+dx[i]
        ny=y+dy[i]
        if nx<0 or nx>n-1 or ny<0 or ny>n-1 or visit[nx][ny]:
            return False
    return True

def gold_calculate(x,y):
    global n
    a=gold[x][y]
    for i in range(5):
        nx=x+dx[i]
        ny=y+dy[i]
        a+=gold[nx][ny]
    return a

def solve(value,cnt):
    global result
    if cnt==3:
        result=min(result,value)
        return
    for i in range(n):
        for j in range(n):
            if check(i,j):
                for i in range(5):
                    nx=j+dx[i]
                    ny=i+dy[i]
                    visit[nx][ny]=1
                solve(value+gold_calculate(i,j),cnt+1)
                print(visit)
                for i in range(5):
                    nx=j+dx[i]
                    ny=i+dy[i]
                    visit[nx][ny]=0

solve(0,0)
print(result)
