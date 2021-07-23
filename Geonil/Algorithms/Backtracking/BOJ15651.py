"""
problem : N과 M 3 (BOJ 15651)
comment : itertools.product 이용
"""
import sys
from itertools import product

In = sys.stdin.readline
N, M = map(int, In().split())


def main():
    sequence = list(product(range(1, N + 1), repeat=M))

    for s in sequence:
        print(" ".join(map(str, s)))


if __name__ == "__main__":
    main()
