import sys
input=sys.stdin.readline

n,m=map(int,input().split())
paper=[]

for i in range(n):
    paper.append(list(map(int,input().split())))

         
tetromino = [
    [(0,0), (0,1), (1,0), (1,1)], 
    [(0,0), (0,1), (0,2), (0,3)], 
    [(0,0), (1,0), (2,0), (3,0)], 
    [(0,0), (0,1), (0,2), (1,0)], 
    [(1,0), (1,1), (1,2), (0,2)],
    [(0,0), (1,0), (1,1), (1,2)], 
    [(0,0), (0,1), (0,2), (1,2)], 
    [(0,0), (1,0), (2,0), (2,1)],
    [(2,0), (2,1), (1,1), (0,1)],
    [(0,0), (0,1), (1,0), (2,0)], 
    [(0,0), (0,1), (1,1), (2,1)],
    [(0,0), (0,1), (0,2), (1,1)], 
    [(1,0), (1,1), (1,2), (0,1)], 
    [(0,0), (1,0), (2,0), (1,1)], 
    [(1,0), (0,1), (1,1), (2,1)], 
    [(1,0), (2,0), (0,1), (1,1)],
    [(0,0), (1,0), (1,1), (2,1)],
    [(1,0), (0,1), (1,1), (0,2)],
    [(0,0), (0,1), (1,1), (1,2)]
]

def solve():
    global answer
    for i in range(n):
        for j in range(m):
            for a in range(19):
                result=0
                for b in range(4):
                    try:
                        nx=i+tetromino[a][b][0]
                        ny=j+tetromino[a][b][1]
                        result+=paper[nx][ny]
                    except IndexError:
                        continue
                answer=max(answer,result)

answer=0
solve()
print(answer)
