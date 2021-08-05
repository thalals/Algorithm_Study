import sys
input=sys.stdin.readline

N=int(input())
second=int(input())

dal=[[0]*N for _ in range(N)]
a,b=0,0
value=N**2
round=0
end=False

while True:
    # 아래방향
    for a in range(0+round,N-round):
        dal[a][b]=value
        value-=1
        if value==0:
            end=True
            break
    if end:
        break
    round+=1
    # 오른쪽방향
    for b in range(0+round,N-round+1):
        dal[a][b]=value
        value-=1
    # 올라가는방향
    for a in range(N-1-round,-2+round,-1):
        dal[a][b]=value
        value-=1
    # 왼쪽
    for b in range(N-1-round,-1+round,-1):
        dal[a][b]=value
        value-=1

a,b=0,0
for i in range(N):
    print(*dal[i])
    if second in dal[i]:
        a=i+1
        b=dal[i].index(second)+1

print(a,b)