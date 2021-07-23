"""
problem : N과 M 10 (BOJ 15664)
comment : collections.OrderedDict, itertools.combinations, sort 이용
"""
import sys
from itertools import combinations
from collections import OrderedDict

In = sys.stdin.readline
N, M = map(int, In().split())
input_list = list(map(int, In().split()))
input_list.sort()


def main():
    sequence = list(OrderedDict.fromkeys(list(combinations(input_list, M))))

    for s in sequence:
        print(" ".join(map(str, s)))


if __name__ == "__main__":
    main()
