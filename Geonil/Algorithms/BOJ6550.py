# 부분 문자열 (BOJ 6550)
import sys
In = sys.stdin.readline


def is_substring(sub: str, string: str) -> bool:
    idx: int = 0

    for t in string:
        if sub[idx] == t:
            idx += 1
            if idx == len(sub):
                return True

    return False


def main():
    while True:
        try:
            s, t = map(str, In().rstrip().split())
            if is_substring(s, t):
                print('Yes')
            else:
                print('No')
        except ValueError or EOFError:
            break


if __name__ == "__main__":
    main()
