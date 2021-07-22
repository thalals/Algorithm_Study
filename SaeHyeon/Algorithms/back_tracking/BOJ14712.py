import sys
input=sys.stdin.readline

N,M=map(int,input().split())

BBuyo=[[0 for _ in range(M+1)] for _ in range(N+1)]

#print(BBuyo)

answer=0

def dfs(cnt):
    global answer
    if cnt==N*M:
        answer+=1
        return

    y=cnt//M+1
    x=cnt%M+1
    
    if BBuyo[y-1][x] == 0 or BBuyo[y][x-1]==0 or BBuyo[y-1][x-1]==0:
        BBuyo[y][x]=1
        # for i in range(len(BBuyo)):
        #     print(BBuyo[i])
        # print()
        dfs(cnt+1)
        BBuyo[y][x]=0
        
    dfs(cnt+1)
    

dfs(0)
print(answer)

