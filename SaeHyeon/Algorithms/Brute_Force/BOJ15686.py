import sys
input=sys.stdin.readline


N,M=map(int,input().split())
city=[list(map(int,input().split())) for _ in range(N)]

print(city)