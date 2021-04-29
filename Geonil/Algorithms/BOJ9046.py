# 복호화 (BOJ 9046)
import sys
from collections import defaultdict
In = sys.stdin.readline


def frequency(string: str) -> str:
    alpha_dict = defaultdict(int)
    for c in string:
        if not c == ' ':
            alpha_dict[c] += 1

    cnt = 0
    flag = False
    max_char = '?'

    for key, value in alpha_dict.items():
        if value > cnt:
            cnt = value
            max_char = key
            flag = False
        elif value == cnt:
            flag = True

    if flag:
        return '?'
    else:
        return max_char


def main():
    t = int(In())
    for _ in range(t):
        string = In().rstrip()
        print(frequency(string))


if __name__ == "__main__":
    main()
