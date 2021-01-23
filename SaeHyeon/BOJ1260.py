import sys
input=sys.stdin.readline

n,m,v=map(int,input().split())
visit=[0]*(n+1)
matrix=[[0]*(n+1) for i in range(n+1)]
#print(visit)
#print(matrix)
result1=[]
result2=[]
for i in range(0,m):
    a,b=map(int,input().split())
    matrix[a][b]=matrix[b][a]=1

#다른 방식 graph = [[] for _ in range(N + 1)]
def DFS(v):
    visit[v]=1
    result1.append(v)
    for i in range(1,n+1):
        if visit[i]==0 and matrix[v][i]==1:
            DFS(i)


def BFS(v):
    q=[v]
    visit[v]=1
    while q:
        d=q.pop(0)
        result2.append(d)
        for i in range(1,n+1):
            if visit[i] == 0 and matrix[d][i] == 1:
                q.append(i)
                visit[i]=1

DFS(v)
for i in range(len(result1)):
    print(result1[i],end=' ')
print()
visit=[0]*(n+1)
BFS(v)
for i in range(len(result2)):
    print(result2[i],end=' ')