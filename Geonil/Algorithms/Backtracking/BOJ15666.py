"""
problem : N과 M 12 (BOJ 15666)
comment : collections.OrderedDict, itertools.combinations_with_replacement, sort 이용
"""
import sys
from itertools import combinations_with_replacement
from collections import OrderedDict

In = sys.stdin.readline
N, M = map(int, In().split())
input_list = list(map(int, In().split()))
input_list.sort()


def main():
    sequence = list(OrderedDict.fromkeys(list(combinations_with_replacement(input_list, M))))

    for s in sequence:
        print(" ".join(map(str, s)))


if __name__ == "__main__":
    main()
