# 문제 : BOJ 4396
# 내용 : 틀림

import sys
input=sys.stdin.readline

n=int(input())
dic={}
for i in range(n):
    arr=list(input().rstrip())
    #print(arr)
    for j in range(len(arr)):
        if arr[j]=='*':
            dic[i,j]=1

result=[]

dir_xy=[[-1,0],[-1,1],[0,1],[1,1],[1,0],[1,-1],[0,-1],[-1,-1]]

def check(a,b):
    cnt=0
    for i in range(len(dir_xy)):
        na=a+dir_xy[i][0]
        nb=b+dir_xy[i][1]
        if 0<=na <n and 0<=nb<n:
            if (na,nb) in dic.keys():
                cnt+=1
    return cnt

for i in range(n):
    arr=list(input().rstrip())
    s=''
    for j in range(len(arr)):
        if arr[j]=='x':
            s+=str(check(i,j))
        elif (i,j) in dic.keys():
            s+='*'
        else:
            if arr[j]=='.':
                s+='.'
         
    result.append(s)

for i in range(len(result)):
    print(result[i])
    
