# 단어 정렬 (BOJ 1181)
import sys
from collections import defaultdict
In = sys.stdin.readline


def main():
    n = int(In())
    d_dict = defaultdict(set)
    keys = set([])

    for _ in range(n):
        sub = In().rstrip()
        size = len(sub)
        d_dict[size].add(sub)
        keys.add(size)

    keys = list(keys)
    keys.sort()
    for key in keys:
        strings = list(d_dict[key])
        strings.sort()
        for string in strings:
            print(string)


if __name__ == "__main__":
    main()
