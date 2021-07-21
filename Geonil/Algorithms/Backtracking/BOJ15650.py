"""
problem : N과 M 2 (BOJ 15650)
comment : itertools.combinations 이용
"""
import sys
from itertools import combinations

In = sys.stdin.readline
N, M = map(int, In().split())


def main():
    sequence = list(combinations(range(1, N + 1), M))

    for s in sequence:
        print(" ".join(map(str, s)))


if __name__ == "__main__":
    main()
