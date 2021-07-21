"""
problem : 부분 수열 합 (BOJ 1182)
comment : itertools.combinations 이용
"""
import sys
from itertools import combinations

In = sys.stdin.readline

N, S = map(int, In().split())
input_list = list(map(int, In().split()))


def main():
    answer = 0

    for i in range(1, N + 1):
        sequence = list(combinations(input_list, i))

        for s in sequence:
            if sum(s) == S:
                answer += 1

    print(answer)


if __name__ == "__main__":
    main()
