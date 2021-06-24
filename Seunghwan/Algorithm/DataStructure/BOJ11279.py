# 최소힙을 활용

# IDEA: y = -x 변환을 하면 최솟값 정렬이 최댓값 정렬로 바뀐다.

# 힙에 원소를 추가할 때 (-item, item)의 튜플 형태로 넣어주면
# 튜플의 첫 번째 원소를 우선순위로 힙을 구성하게 된다.
# 이때 원소 값의 부호를 바꿨기 때문에,
# 최소 힙으로 구현된 heapq 모듈을 최대 힙 구현에
# 활용하게 되는 것이다.

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
        heapq.heappush(data, [-num, num])
