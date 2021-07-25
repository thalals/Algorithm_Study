# 문제 : BOJ6443
# 내용 : 결과는 같으나 메모리 초과 나옴

import sys
from itertools import permutations

N=int(input())

arr=[]

def backtracking(idx):
    global s
    if idx == len(s):
        abc=''.join(arr)
        result.add(abc)
        return

    for i in range(0,len(s)):
        if visit[i]:
            continue

        visit[i]=True
        arr.append(s[i])
        backtracking(idx+1)
        arr.pop()
        visit[i]=False

for _ in range(N):
    s=list(input().rstrip())
    visit=[False]*len(s)
    s.sort()
    result=set()
    backtracking(0)
    #print(sorted(result))
    for i in sorted(list(result)):
        print(i)
    #result=list(set(result))
    # for i in sorted(result):
    #     print(i)
    