"""
problem : 링크와 스타트  (BOJ 15661)
comment : combination 이용, 최소값 구하기
"""
import sys
from itertools import combinations

In = sys.stdin.readline

n = int(In())
person = set([i for i in range(n)])
startlink = []
answer = float("inf")


def get_ability(team):
    length = len(team)
    ability = 0

    for i in range(length - 1):
        for j in range(i + 1, length):
            x, y = team[i], team[j]
            ability += startlink[x][y]

    return ability


def solve():
    global answer

    for i in range(1, n // 2 + 1):
        combs = list(combinations(person, i))

        for team_a in combs:
            diff = get_ability(team_a) - get_ability(list(person - set(team_a)))
            answer = min(answer, abs(diff))


def main():
    for i in range(n):
        startlink.append(list(map(int, In().split())))

    # add bottom triangle
    for i in range(n):
        for j in range(n):
            startlink[i][j] += startlink[j][i]

    solve()
    print(answer)


if __name__ == "__main__":
    main()
