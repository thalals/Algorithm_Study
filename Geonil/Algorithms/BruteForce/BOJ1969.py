"""
problem : DNA (BOJ 1969)
comment : 
"""
import sys
from collections import defaultdict

In = sys.stdin.readline

alpha = ("A", "C", "G", "T")


def solve(n, m, dna_lst):
    dna = ""
    distance = 0

    for j in range(m):
        dna_distance = defaultdict(int)
        for i in range(n):
            dna_distance[dna_lst[i][j]] += 1
        max_ = max(dna_distance.values())
        flag = False
        for c in alpha:
            if dna_distance[c] == max_ and not flag:
                dna += c
                flag = True
            else:
                distance += dna_distance[c]

    return dna, distance


def main():
    n, l = map(int, In().split())

    dna_lst = []
    for _ in range(n):
        dna_lst.append(In().rstrip())
    dna, distance = solve(n, l, dna_lst)
    print("\n".join([dna, str(distance)]))


if __name__ == "__main__":
    main()
