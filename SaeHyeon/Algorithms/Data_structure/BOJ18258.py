#Problem : https://www.acmicpc.net/problem/18258
#Comment : 해결

import sys
from collections import deque

input=sys.stdin.readline


def queue(arr,s):
    if s[0] == 'push':
        arr.append(s[1])
    if s[0] == 'pop':
        if arr:
            print(arr.popleft())
        else:
            print(-1)
    if s[0] == 'size':
        print(len(arr)) 
    if s[0] == 'empty':
        if arr:
            print(0)
        else:
            print(1)
    if s[0] == 'front':
        if not arr:
            print(-1)
        else:
            print(arr[0])
    if s[0] == 'back':
        if not arr:
            print(-1)
        else:
            print(arr[-1])
    

n=int(input())
if n>=1 and n<=2000000:
    arr=deque([])
    for i in range(n):
        s=input().split()
        queue(arr,s)
