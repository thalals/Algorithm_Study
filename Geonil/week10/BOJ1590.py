# 캠프가는 영식
import sys
In = sys.stdin.readline


def main():
    n, t = map(int, In().split())
    buses = []

    ans = float('inf')

    for _ in range(n):
        start, interval, num = map(int, In().split())

        for i in range(num):
            if t <= start:
                ans = min(ans, start-t)
                break
            start += interval

    if ans == float('inf'):
        print(-1)
    else:
        print(ans)


if __name__ == "__main__":
    main()
