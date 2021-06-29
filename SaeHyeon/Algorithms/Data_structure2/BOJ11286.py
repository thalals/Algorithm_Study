#Problem : https://www.acmicpc.net/problem/11286
#Comment : 해결

import sys
import heapq

input=sys.stdin.readline
heap=[]

n=int(input())

for i in range(n):
    a=int(input())
    if a == 0:
        if len(heap) == 0:
            print(0)
            continue
        print(heapq.heappop(heap)[1])
        continue
    heapq.heappush(heap,(abs(a),a))

#print(heap)