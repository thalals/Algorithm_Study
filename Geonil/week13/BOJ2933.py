# 미네랄
import sys
In = sys.stdin.readline

dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]


def main():
    r, c = map(int, In().split())

    cave = []
    for _ in range(r):
        sub = list(map(str, In().rstrip()))
        cave.append(sub)

    num = int(In())
    sticks = list(map(int, In().split()))


if __name__ == "__main__":
    main()
