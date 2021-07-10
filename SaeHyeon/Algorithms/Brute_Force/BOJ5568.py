import sys
from itertools import permutations
input=sys.stdin.readline

n=int(input())
k=int(input())

li=set()
arr=[]
for _ in range(n):
    arr.append(input().rstrip())

for a in permutations(arr,k):
    li.add(''.join(a))

print(len(li))
