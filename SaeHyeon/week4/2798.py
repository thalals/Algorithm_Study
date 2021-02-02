import sys
import random

input= sys.stdin.readline

N,M= map(int,input().split())
black = list(map(int,input().split(' ')))
sum=0

# print(black)

for i in range(0,N-2):
    for j in range(i+1,N-1):
        for k in range(j+1,N):
            if (black[i]+black[j]+black[k]) > M:
                continue
            else:
                sum=max(sum,black[i]+black[j]+black[k])

print(sum)