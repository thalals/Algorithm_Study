# 문제 : 백준 3980
# 내용 : 답은 나왔지만 제출 결과는 틀림
#        아마 능력치를 뽑은 선수는 방문 처리 해줘야 되는 거 같음

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