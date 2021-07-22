import sys
input=sys.stdin.readline

N=int(input())
egg=[]

for i in range(N):
    egg.append(list(map(int,input().split())))

max_value=0

def dfs(c):
    global max_value
    # 깊이가 계란의 갯수와 같아진다면 
    # egg 배열을 검사하여 내구도가 0보다 아래면은 
    # 깨진 계란 갯수+1
    if c==len(egg):
        count=0
        for i in range(len(egg)):
            if egg[i][0] <= 0:
                count+=1
        if count >max_value:
            max_value=count
        return
    
    # 만약 계란이 깨져있다면 다음 계란으로 
    if egg[c][0] <= 0:
        dfs(c+1)
    # 계란이 안 깨져있다면
    else:
        flag=False
        # 계란을 다 찾으면서 현재 계란과 반복문 중의 계란을 부딪힌다.
        for i in range(len(egg)):
            # 반복문의 계란과 지금 현재 계란이면 다음으로
            # 이미 부서져 있어도 다음 계란으로
            if i==c or egg[i][0] <=0:
                continue
            # 두개의 계란 서로 부딪히기
            egg[c][0] -= egg[i][1]
            egg[i][0] -=egg[c][1]
            flag=True
            dfs(c+1)
            # 원래대로
            egg[c][0] += egg[i][1]
            egg[i][0] +=egg[c][1]
        if not flag:
            dfs(c+1)
    return

dfs(0)
print(max_value)