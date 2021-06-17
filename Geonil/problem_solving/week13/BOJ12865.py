# 평범한 배낭
import sys
In = sys.stdin.readline


def main():
    n, k = map(int, In().split())
    items = []

    for _ in range(n):
        items.append(list(map(int, In().split())))

    lst = [0] * (k+1)

    for w, v in items:
        for i in range(k, 0, -1):
            if w <= i:
                lst[i] = max(lst[i-w] + v, lst[i])

    print(lst[k])


if __name__ == "__main__":
    main()
