# 괜히 뻘짓하다가 시간만 날렸다 그냥 순열로 풀면 된다.

import sys

input = sys.stdin.readline
from itertools import permutations

n = int(input())
k = int(input())

data = []

for i in range(n):
    data.append(input())

result = set()

for i in permutations(data, k):
    result.add(''.join(i))

print(len(result))