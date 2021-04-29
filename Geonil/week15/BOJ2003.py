# 수들의 합 2 (BOJ 2003)
# two pointer(left, right)
import sys
In = sys.stdin.readline


def search_target(lst: list, target: int) -> int:
    length = len(lst)

    left: int = 0
    right: int = 0

    cnt: int = 0
    num: int = lst[left]

    while True:
        if num == target:
            cnt += 1
            num -= lst[left]
            left += 1
        elif num > target:
            num -= lst[left]
            left += 1
        else:
            right += 1

            if right == length:
                break
            num += lst[right]

    return cnt


def main():
    n, target = map(int, In().split())
    lst = list(map(int, In().split()))
    print(search_target(lst, target))


if __name__ == "__main__":
    main()
