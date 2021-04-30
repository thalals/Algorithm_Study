# 그룹단어 체커 (BOJ 1316)
import sys
from collections import defaultdict
In = sys.stdin.readline


def check_group_word(string: str) -> bool:
    alpha = defaultdict(bool)

    for idx in range(0, len(string)-1):
        if alpha[string[idx+1]]:
            return False

        if string[idx] == string[idx+1]:
            continue
        else:
            alpha[string[idx]] = True

    return True


def main():
    n = int(In())
    answer = 0

    for _ in range(n):
        if check_group_word(In().rstrip()):
            answer += 1

    print(answer)


if __name__ == "__main__":
    main()
