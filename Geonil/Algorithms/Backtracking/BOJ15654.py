"""
problem : N과 M 5 (BOJ 15654)
comment : itertools.permutations, sort 이용
"""
import sys
from itertools import permutations

In = sys.stdin.readline
N, M = map(int, In().split())
input_list = list(map(int, In().split()))
input_list.sort()


def main():
    sequence = list(permutations(input_list, M))

    for s in sequence:
        print(" ".join(map(str, s)))


if __name__ == "__main__":
    main()
