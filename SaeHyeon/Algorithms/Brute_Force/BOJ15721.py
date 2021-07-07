#Problem : https://www.acmicpc.net/problem/15721
#Comment : 결과는 맞게 나왔는데 틀림, 나중에 다시 풀어보기

import sys
input=sys.stdin.readline

a=int(input())
t=int(input())
s=int(input())


i=0
cnt=0
bundegi=[]
people=0
c=True

while(c):
    if a==1:
        print(0)
        c=False
    i+=1
    bundegi=bundegi+[0,1,0,1]
    for j in range(1,i+1):
        bundegi.append(0)
    for j in range(1,i+1):
        bundegi.append(1)

    for k in range(len(bundegi)):
        if bundegi[k]==s:
            cnt+=1
        if cnt == t:
            print(people)
            c=False
            break
        people+=1
        people%=a