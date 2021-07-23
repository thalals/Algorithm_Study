"""
problem : N과 M 1 (BOJ 15649)
comment : itertools.permutations 이용
"""
import sys
from itertools import permutations

In = sys.stdin.readline
N, M = map(int, In().split())


def main():
    sequence = list(permutations(range(1, N + 1), M))

    for s in sequence:
        print(" ".join(map(str, s)))


if __name__ == "__main__":
    main()
