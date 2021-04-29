# N과M(1)
import sys
from itertools import permutations
In = sys.stdin.readline

n, m = map(int, In().split())


def main():
    lst = []
    for i in range(n):
        lst.append(i+1)
    p = list(permutations(lst, m))

    for i in range(len(p)):
        for j in range(m):
            print(p[i][j], end=' ')
        print()


if __name__ == "__main__":
    main()
