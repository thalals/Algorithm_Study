"""
problem : N과 M 7 (BOJ 15656)
comment : itertools.product, sort 이용
"""
import sys
from itertools import product

In = sys.stdin.readline
N, M = map(int, In().split())
input_list = list(map(int, In().split()))
input_list.sort()


def main():
    sequence = list(product(input_list, repeat=M))

    for s in sequence:
        print(" ".join(map(str, s)))


if __name__ == "__main__":
    main()
