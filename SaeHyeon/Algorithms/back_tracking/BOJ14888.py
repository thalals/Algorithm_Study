import sys
input=sys.stdin.readline

N=int(input())
A=list(map(int,input().split()))
operator=list(map(int,input().split()))
min_result=10**8
max_result=0

def result(x,y,operator):
    if operator == 0:
        return x+y
    if operator == 1:
        return x-y
    if operator == 2:
        return x*y
    else:
        if x<0:
            value=(-x)//y
            return -value
        else:
            return x//y

def dfs(idx,start):
    global min_result
    global max_result

    if idx==N-1:
        min_result=min(start,min_result)
        max_result=max(start,max_result)
        return
    
    # 연산자 체크
    for i in range(4):
        # 연산자가 없으면 다음으로
        if operator[i%4]==0:
            continue

        operator[i%4]-=1
        dfs(idx+1,result(start,A[idx+1],i%4))
        operator[i%4]+=1

dfs(0,A[0])

print(max_result)
print(min_result)