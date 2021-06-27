import sys
import heapq

input = sys.stdin.readline

t = int(input())  # 데이터의 수

for _ in range(t):

    max_q, min_q = [], []
    visit = [False] * 1000001

    k = int(input())

    for i in range(k):
        do, num = input().split()
        if do == 'I':
            heapq.heappush(min_q, (int(num), i))
            heapq.heappush(max_q, (-int(num), i))
            visit[i] = True
        elif num == '-1':
            while min_q and not visit[min_q[0][1]]:
                heapq.heappop(min_q)
            if min_q:
                visit[min_q[0][1]] = False
                heapq.heappop(min_q)
        else:
            while max_q and not visit[max_q[0][1]]:
                heapq.heappop(max_q)
            if max_q:
                visit[max_q[0][1]] = False
                heapq.heappop(max_q)

    while min_q and not visit[min_q[0][1]]:
        heapq.heappop(min_q)
    while max_q and not visit[max_q[0][1]]:
        heapq.heappop(max_q)

    print(f'{-max_q[0][0]} {min_q[0][0]}' if max_q and min_q else 'EMPTY')
