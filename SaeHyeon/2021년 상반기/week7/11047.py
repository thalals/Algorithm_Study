# N,K=map(int,input().split())
# coin=[]
# cnt=0

# for i in range(N):
#     coin.append(int(input()))
# #print(*coin)


# for j in range(N-1,-1,-1):
#     if K==0:
#         break
#     if coin[j] > K:  # if coin[j] >= K로 하니깐 틀림 
#         continue
#     cnt += K//coin[j]
#     #K-=coin[j]*num
#     K %= coin[j]

# print(cnt)

import sys
input=sys.stdin.readline

N,K=map(int,input().split())
coin=[]
for i in range(N):
    coin.append(int(input()))
coin.reverse()
#print(*coin)
cnt,j=0,0

for j in range(N):
    if K==0:
        break
    if coin[j] > K: # 조건에서 = 빼야함
        continue
    num=K//coin[j]
    cnt+=num
    K-=coin[j]*num

print(cnt)
