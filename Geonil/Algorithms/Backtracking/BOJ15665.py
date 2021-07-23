"""
problem : N과 M 11 (BOJ 15665)
comment : collections.OrderedDict, itertools.product, sort 이용
"""
import sys
from itertools import product
from collections import OrderedDict

In = sys.stdin.readline
N, M = map(int, In().split())
input_list = list(map(int, In().split()))
input_list.sort()


def main():
    sequence = list(OrderedDict.fromkeys(list(product(input_list, repeat=M))))

    for s in sequence:
        print(" ".join(map(str, s)))


if __name__ == "__main__":
    main()
