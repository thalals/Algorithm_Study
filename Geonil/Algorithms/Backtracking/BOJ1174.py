"""
problem : 줄어드는 숫자 (BOJ 1174)
comment : 10C1 to 10C10 경우의수
"""
import sys
from itertools import combinations


def intput():
    return sys.stdin.readline().rstrip()


N = int(input())
number = [i for i in range(10)]
answer = []


def init():
    for i in range(1, 11):
        comb = combinations(number, i)
        for c in comb:
            num = 0
            for e, n in enumerate(sorted(c)):
                num += (10 ** e) * n
            answer.append(num)


def main():
    init()
    answer.sort()
    try:
        print(answer[N - 1])
    except IndexError:
        print(-1)


if __name__ == "__main__":
    main()
