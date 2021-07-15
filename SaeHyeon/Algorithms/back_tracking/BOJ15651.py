import sys
input=sys.stdin.readline

N,M=map(int,input().split())

number=[i+1 for i in range(N+1)]
visited=[False]*N
arr=[]

def dfs(cnt):
    if cnt == M:
        print(*arr)
        return
    
    for i in range(N):
        if visited[i]:
            continue

        #visited[i]=True
        arr.append(number[i])
        dfs(cnt+1)
        arr.pop()
        # for j in range(i+1,N):
        #     visited[j]=False

dfs(0)