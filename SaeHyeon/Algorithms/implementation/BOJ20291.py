import sys
input=sys.stdin.readline

N=int(input())
dic={}
for _ in range(N):
    a,b=map(str,input().rstrip().split('.'))
    if b in dic:
        dic[b]+=1
    else:
        dic[b]=1
new_dic=sorted(dic.items())
for a,b in new_dic:
    print(a,b)