"""
problem : N과 M 6 (BOJ 15655)
comment : itertools.combinations, sort 이용
"""
import sys
from itertools import combinations

In = sys.stdin.readline
N, M = map(int, In().split())
input_list = list(map(int, In().split()))
input_list.sort()


def main():
    sequence = list(combinations(input_list, M))

    for s in sequence:
        print(" ".join(map(str, s)))


if __name__ == "__main__":
    main()
