import sys
input=sys.stdin.readline

t=int(input())
status=[]
max_result=0
for _ in range(11):
    status.append(list(map(int,input().split())))

def backtracking(idx,result):
    global max_result

    if idx==11:
        max_result=max(max_result,result)
        return

    for i in range(11):
        if status[idx][i]==0:
            continue
        result=result+status[idx][i]
        backtracking(idx+1,result)
        result=result-status[idx][i]

for _ in range(t):
    backtracking(0,0)
    print(max_result)