"""
problem : 카드섞기 (BOJ 21315)
comment : k+1 단계 , 슬라이스, 완전탐색
"""
import sys
from collections import deque

In = sys.stdin.readline

N = int(In())
cards = list(map(int, In().split()))


def shuffle(dummies, k):
    shuffled = deque()

    for i in range(1, k + 2):
        idx = len(dummies) - (2 ** (k - i + 1))
        for c in reversed(dummies[:idx]):
            shuffled.appendleft(c)
        dummies = dummies[idx:]

    for c in shuffled:
        dummies.append(c)

    return dummies


def main():
    k = int(N ** 0.5)
    for i in range(1, k + 1):
        for j in range(1, k + 1):
            dummies = [n for n in range(1, N + 1)]
            dummies = shuffle(dummies, i)
            dummies = shuffle(dummies, j)
            if list(dummies) == cards:
                print(i, j)
                return


if __name__ == "__main__":
    main()
