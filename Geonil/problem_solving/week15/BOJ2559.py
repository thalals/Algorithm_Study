# 수열 (BOJ 2559)
import sys
In = sys.stdin.readline


def get_max_temperature(lst: list, days: int) -> int:
    lenght: int = len(lst)
    left: int = 0
    right: int = days-1
    num: int = sum(lst[left:right+1])
    max_tem = num

    while True:
        if right == lenght-1:
            break

        left += 1
        right += 1

        num += (lst[right]-lst[left-1])
        max_tem = max(max_tem, num)

    return max_tem


def main():
    n, days = map(int, In().split())
    lst = list(map(int, In().split()))
    print(get_max_temperature(lst, days))


if __name__ == "__main__":
    main()
