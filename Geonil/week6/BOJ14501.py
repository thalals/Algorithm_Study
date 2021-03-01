import sys
from itertools import permutations
In = sys.stdin.readline

n = int(In())

data = [1, 5]

p = list(permutations(data, n))

print(p)
