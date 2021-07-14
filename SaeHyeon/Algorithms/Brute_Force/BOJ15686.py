import sys
from itertools import combinations
input=sys.stdin.readline

N,M=map(int,input().split())
city=[list(map(int,input().split())) for _ in range(N)]

house=[]
chicken=[]
for i in range(N):
    for j in range(N):
        if city[i][j] == 1:
            house.append([i,j])
        elif city[i][j] == 2:
            chicken.append([i,j])

#print(house)
#print(chicken)

min_result=10**8

for re_ch in combinations(chicken,M):
    #print(re_ch) 
    sum_distance=0
    for h in house:
        result=[]
        for i in re_ch:
            result.append(abs(h[0]-i[0])+abs(h[1]-i[1]))
        sum_distance+=min(result)
        if min_result <= sum_distance:
            break
    if sum_distance < min_result:
        min_result = sum_distance

print(min_result)