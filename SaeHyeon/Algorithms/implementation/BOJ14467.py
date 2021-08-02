import sys
input=sys.stdin.readline

N=int(input())
dic={}
cnt=0
for _ in range(N):
    a,b=map(int,input().split())

    if a not in dic.keys():
        dic[a]=b
    if a in dic.keys():
        if dic[a]==b:
            continue
        else:
            cnt+=1
            dic[a]=b

print(cnt)