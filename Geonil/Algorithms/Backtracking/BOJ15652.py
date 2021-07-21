"""
problem : N과 M 4 (BOJ 15652)
comment : itertools.combinations_with_replacement 이용
"""
import sys
from itertools import combinations_with_replacement

In = sys.stdin.readline
N, M = map(int, In().split())


def main():
    sequence = list(combinations_with_replacement(range(1, N + 1), M))

    for s in sequence:
        print(" ".join(map(str, s)))


if __name__ == "__main__":
    main()
