import sys

"""
N : 회의 수
"""
i = 0
cnt = 1
N = int(sys.stdin.readline().rstrip())
time = []

while i < N:
    start, finish = map(int, sys.stdin.readline().rstrip().split())
    time.append([finish, start])
    i += 1

# 시간순 정렬
time = sorted(time)
now = time[0][0]

for i in range(1, N):
    if time[i][1] < now:
        continue
    else:
        cnt += 1
        now = time[i][0]

print(cnt)
