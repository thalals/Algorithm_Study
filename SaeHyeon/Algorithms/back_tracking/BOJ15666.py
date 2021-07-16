import sys
input=sys.stdin.readline

N,M=map(int,input().split())

number=sorted(list(map(int,input().split())))
visited=[False]*N
arr=[]
result={}

def dfs(cnt):
    if cnt == M:
        s=' '.join(map(str,arr))
        if s not in result:
            result[s]=1
            print(s)
        return
    
    for i in range(N):
        if visited[i]:
            continue

        
        arr.append(number[i])
        dfs(cnt+1)
        visited[i]=True
        arr.pop()
        for j in range(i+1,N):
            visited[j]=False

dfs(0)