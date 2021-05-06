# 문자열 게임 2 (BOJ 20437)
import sys
from collections import defaultdict, deque
In = sys.stdin.readline


def check_string(string: str, num: int) -> list:
    d_dict = defaultdict(list)
    minimum = float('inf')
    maximum = float('-inf')

    for idx, char in enumerate(string):
        if d_dict[char]:
            d_dict[char][0] += 1
            d_dict[char][1].append(idx)
            if d_dict[char][0] == num:
                length = idx - d_dict[char][1][0] + 1
                minimum = min(minimum, length)
                maximum = max(maximum, length)
                d_dict[char][1].popleft()
                d_dict[char][0] -= 1
        else:
            d_dict[char] = [1, deque([idx])]

    return [minimum, maximum]


def main():
    t = int(In())
    for _ in range(t):
        string = In().rstrip()
        k = int(In())
        if k == 1:
            print(1, 1)
            continue

        mini, maxi = check_string(string, k)
        if mini == float('inf'):
            print(-1)
        else:
            print(mini, maxi)


if __name__ == "__main__":
    main()
