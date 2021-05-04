# 나는 친구가 적다 (Small) (BOJ 16171)
import sys
In = sys.stdin.readline


def main():
    string = In().rstrip()
    keyword = In().rstrip()

    new_string: str = ''

    for c in string:
        if c.isdigit():
            continue
        new_string += c

    if keyword in new_string:
        print(1)
    else:
        print(0)


if __name__ == "__main__":
    main()
