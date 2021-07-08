import sys
input=sys.stdin.readline

n,m=map(int,input().split())
card=[*map(int,input().split())]
result=0

for i in range(len(card)-2):
    for j in range(i+1,len(card)-1):
        for k in range(j+1,len(card)):
            if(card[i]+card[j]+card[k]) > m:
                continue
            else:
                result=max(result,card[i]+card[j]+card[k])

print(result)