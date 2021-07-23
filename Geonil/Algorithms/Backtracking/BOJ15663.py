"""
problem : N과 M 9 (BOJ 15663)
comment : collections.OrderedDict, itertools.permutations, sort 이용
"""
import sys
from itertools import permutations
from collections import OrderedDict

In = sys.stdin.readline
N, M = map(int, In().split())
input_list = list(map(int, In().split()))
input_list.sort()


def main():
    sequence = list(OrderedDict.fromkeys(list(permutations(input_list, M))))

    for s in sequence:
        print(" ".join(map(str, s)))


if __name__ == "__main__":
    main()
