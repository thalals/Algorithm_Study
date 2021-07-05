import sys
from itertools import product

input=sys.stdin.readline

n,k=map(int,input().split())
arr=list(map(str,input().split()))
length=len(str(n))

while True:
    tmp=list(product(arr,repeat=length))
    answer=[]

    for i in tmp:
        if int(''.join(i)) <=n:
            answer.append(int(''.join(i)))

    if len(answer) >= 1:
        print(max(answer))
        break
    else:
        length-=1
        
# ---------------1차 -------------------
# n,k=map(int,input().split())
# arr=list(map(str,input().rstrip().split()))

# li=set()

# for i in range(1,k+1):
#     for j in product(arr, repeat=i):
#         li.add(''.join(j))

# max_value=0
# print(li)
# for i in li:
#     if int(i) < n:
#         if int(i) > max_value:
#             max_value=int(i)

# print(max_value)    

