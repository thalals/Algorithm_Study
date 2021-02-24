import sys

"""
K : 동전 종류
N : 가치의 합
"""

i = 0
j = 0
cnt = 0
K, N = map(int, sys.stdin.readline().rstrip().split())
coin_list = []

while i < K:
    coin_list.append(int(sys.stdin.readline().rstrip()))
    i += 1

for coin in coin_list:
    if N > coin:
        j += 1
    else:
        break

while j > 0:
    j -= 1
    cnt += int(N / coin_list[j])
    N %= coin_list[j]

print(cnt)
