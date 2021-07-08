import sys
from itertools import permutations

input=sys.stdin.readline

n,m=map(int,input().split())
icecream=list(permutations(range(1,n+1),3))

print(icecream)

# for _ in range(m):
#     a,b=map(int,input().split())
#     for i in range(len(icecream)):
#         for j in range(3):
#         if a in icecream[i] and b in icecream[i]:
#             icecream.remove(icecream[i])

# print(icecream)
for _ in range(m):
    a,b=map(int,input().split())
    a=list(str(a))
    b=list(str(b))
    for i in range(3):
        for j in range(len(icecream)):
            if a in icecream[j][i] and b in icecream[j][i]:
                icecream.remove(icecream[j])

print(icecream)