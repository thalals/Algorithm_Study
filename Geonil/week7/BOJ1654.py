import sys
sys.setrecursionlimit(10**6)
In = sys.stdin.readline

k, n = map(int, In().split())
lan_wire = []

for _ in range(k):
    lan_wire.append(int(In()))


def check_n(mid):
    cnt = 0
    for item in lan_wire:
        cnt += item//mid
    return cnt


def binary_search(left, right):
    mid = (left+right+1)//2

    cnt = check_n(mid)

    if left >= right:
        return right

    if cnt < n:
        return binary_search(left, mid-1)
    else:
        return binary_search(mid+1, right)


def main():
    less_length = 1
    max_length = max(lan_wire)

    print(binary_search(less_length, max_length))


if __name__ == "__main__":
    main()
