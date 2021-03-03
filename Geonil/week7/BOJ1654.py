import sys
In = sys.stdin.readline

k, n = map(int, In().split())
lan_wire = []

for _ in range(k):
    lan_wire.append(int(In()))


def binary_search(left, right):
    mid = (left+right)//2
    cnt = 0

    for item in lan_wire:
        cnt += item//mid

    if left == right:
        return mid

    if cnt < n:
        return binary_search(left, mid-1)
    else:
        return binary_search(mid, right)


def main():

    less_length = 1
    max_length = max(lan_wire)
    answer = 1
    mid = 1

    while less_length <= max_length:
        cnt = 0
        mid = max(1, (less_length + max_length)//2)

        for item in lan_wire:
            cnt += item//mid

        if cnt > n:
            less_length = mid + 1
            answer = max(answer, mid)
        elif cnt < n:
            max_length = mid - 1
        else:
            answer = max(answer, mid)
            break

    while True:
        cnt = 0
        mid = answer + 1
        for item in lan_wire:
            cnt += item//mid

        if cnt < n:
            break
        else:
            answer = mid

    print(answer)


if __name__ == "__main__":
    main()
