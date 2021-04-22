# 순열
# itertools.permutations 이용 메모리 초과
import sys
from itertools import permutations
In = sys.stdin.readline


def solution(string, num):
    per = list(permutations(string))
    try:
        print(string, num, '=', ''.join(per[num-1]))
    except IndexError as IE:
        print(string, num, '= No permutation')


def main():
    while True:
        try:
            string, num = map(str, In().rstrip().split())
            solution(string, int(num))
        except ValueError as VE:
            break


if __name__ == "__main__":
    main()
