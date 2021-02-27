import sys
import math
In = sys.stdin.readline


def main():
    # read data
    k, n = map(int, In().split())
    lan_wire = []
    for _ in range(k):
        lan_wire.append(int(In()))

    # 최소 개수
    x = math.ceil(n / k)
    less_length = min(lan_wire)//x

    while True:
        cnt = 0
        for item in lan_wire:
            cnt += int(item/less_length)

        if cnt < n:
            break

        answer = less_length
        less_length += 1

    print(answer)


if __name__ == "__main__":
    main()
