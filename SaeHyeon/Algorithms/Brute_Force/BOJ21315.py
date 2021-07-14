import sys
input=sys.stdin.readline

N=int(input())
card=list(map(int,input().split()))

def solve(k):
    for i in range(2**k):