import sys
import bisect

si = sys.stdin.readline

n = int(si())
data = list(map(int, si().strip().split()))
update_data = sorted(list(set(data)))

for value in data:
    print(bisect.bisect_left(update_data, value), end = ' ');