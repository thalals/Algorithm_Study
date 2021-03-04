import sys

si = sys.stdin.readline

def isOk(mid):
    sum = 0
    for i in range(k):
        sum += lan[i] // mid
    return sum >= n


k, n = map(int, si().split(' '))
lan = [int(si()) for _ in range(k)]

answer = 0
left = 0
right = 2 ** 31 - 1

while left <= right:
    mid = (left + right) // 2
    if isOk(mid):
        left = mid + 1
        answer = max(answer, mid)
    else:
        right = mid - 1

print(answer)

