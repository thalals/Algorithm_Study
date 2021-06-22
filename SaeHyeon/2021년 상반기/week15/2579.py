import sys
input=sys.stdin.readline

n=int(input())

point=[0 for i in range(301)]
dp=[0 for i in range(301)]

for i in range(n):
    point[i] = int(input())

dp[0] = point[0]
dp[1] = point[0] + point[1]
dp[2] = max(point[0]+point[2],point[1]+point[2])

for i in range(3,n):
    dp[i]=max(dp[i-3]+point[i-1]+point[i],dp[i-2]+point[i])

print(dp[n-1])