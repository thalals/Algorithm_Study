"""
problem : N과 M 8 (BOJ 15657)
comment : itertools.combinations_with_replacement, sort 이용
"""
import sys
from itertools import combinations_with_replacement

In = sys.stdin.readline
N, M = map(int, In().split())
input_list = list(map(int, In().split()))
input_list.sort()


def main():
    sequence = list(combinations_with_replacement(input_list, M))

    for s in sequence:
        print(" ".join(map(str, s)))


if __name__ == "__main__":
    main()
