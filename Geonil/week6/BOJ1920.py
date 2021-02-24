# 수찾기
import sys
In = sys.stdin.readline

n = int(In())
arr = list(map(int, In().split()))

m = int(In())
target = list(map(int, In().split()))


def binary_search(item):
    left = 0
    right = n-1

    while left <= right:
        mid = (left+right)//2
        if arr[mid] > item:
            right = mid-1
        elif arr[mid] < item:
            left = mid+1
        else:
            return 1

    return 0


def main():
    arr.sort()

    for item in target:
        print(binary_search(item))


if __name__ == "__main__":
    main()
