import sys
import math
input=sys.stdin.readline

M,N=map(int,input().split())
numbers=[]
for _ in range(M):
    numbers.append(list(map(int,input().replace('\n',''))))

#print(numbers)

result=-1

for m in range(M):
    for n in range(N):
        for md in range(-M,M):
            for nd in range(-N,N):
                if md==0 and nd == 0:
                    continue