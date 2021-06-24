
# 최소힙을 사용하여 풀이
import sys
import heapq

n = int(sys.stdin.readline())
data = []

for i in range(n):
    num = int(sys.stdin.readline())

    if num == 0:
        if data:
            print(heapq.heappop(data)[1])
        else:
            print(0)
    else:
        heapq.heappush(data, [abs(num), num])
