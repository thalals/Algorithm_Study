import sys
input=sys.stdin.readline

N=int(input())
egg=[]

for i in range(N):
    egg.append(list(map(int,input().split())))

# 0이면 깨진 계란
broke=[0]*N

#print(egg)
max_value=0

def dfs(c):
    global max_value

    if c==len(egg):
        count=0
        for i in range(len(egg)):
            if egg[i][0] <= 0:
                count+=1
        if count >max_value:
            max_value=count
        return
    
    if egg[c][0] <= 0:
        dfs(c+1)
    else:
        flag=False
        for i in range(len(egg)):
            if i==c or egg[i][0] <=0:
                continue
            egg[c][0] -= egg[i][1]
            egg[i][0] -=egg[c][1]
            flag=True
            dfs(c+1)
            egg[c][0] += egg[i][1]
            egg[i][0] +=egg[c][1]
        if not flag:
            dfs(c+1)
    return

dfs(0)
print(max_value)