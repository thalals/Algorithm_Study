import sys
from itertools import permutations
In = sys.stdin.readline

n, k = map(int, In().split())
weight_up = list(map(int, In().split()))
maintain_weight = 500


def check_case(case):
    weight = 500

    for kit in case:
        change = kit - k
        weight += change

        if weight < maintain_weight:
            return False

    return True


def main():
    cases = list(permutations(weight_up, n))
    answer_case = 0

    for case in cases:
        if check_case(case):
            answer_case += 1

    print(answer_case)


if __name__ == "__main__":
    main()
