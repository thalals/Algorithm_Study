# 숫자의 합 (BOJ 11720)
import sys
In = sys.stdin.readline


def main():
    n = int(In())
    nums = In().rstrip()
    result = 0
    for num in nums:
        result += int(num)
    print(result)


if __name__ == "__main__":
    main()
