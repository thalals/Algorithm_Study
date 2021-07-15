import sys
input=sys.stdin.readline

N,M=map(int,input().split())

number=sorted(list(map(int,input().split())))
visited=[False]*N
arr=[]

def dfs(cnt):
    if cnt == M:
        print(*arr)
        return
    
    for i in range(N):
        if visited[i]:
            continue

        arr.append(number[i])
        dfs(cnt+1)
        arr.pop()

dfs(0)