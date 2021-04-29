# 캐슬 디펜스
import sys
import copy
from itertools import combinations
In = sys.stdin.readline


def get_distance(point1, point2):
    return abs(point1[0]-point2[0]) + abs(point1[1]-point2[1])


def get_archers(cols, n):
    archers = []
    for c in cols:
        archers.append([n, c])

    return archers


def turn_archer(enemy, archers, max_dist):
    new_enemy = []
    kills = []

    for archer in archers:
        distance = 100
        exist = False
        kill = None

        for idx, e in enumerate(enemy):
            dist = get_distance(archer, e)

            if dist <= distance and dist <= max_dist:
                if dist == distance:
                    if enemy[kill][1] > enemy[idx][1]:
                        distance = dist
                        kill = idx
                else:
                    distance = dist
                    kill = idx
                    exist = True

        if exist:
            if kill not in kills:
                kills.append(kill)

    for idx, e in enumerate(enemy):
        if idx in kills:
            continue
        new_enemy.append(e)

    return new_enemy, len(kills)


def turn_enenmy(enemy, n):
    new_enemy = []
    for i in range(len(enemy)):
        if enemy[i][0] == n-1:
            continue
        else:
            x, y = enemy[i]
            new_enemy.append([x+1, y])

    return new_enemy


def main():
    n, m, max_distance = map(int, In().split())
    enemy = []
    max_kill = 0

    per = list(combinations(range(m), 3))

    for i in range(n):
        sub = list(map(int, In().split()))
        for j, item in enumerate(sub):
            if item == 1:
                enemy.append([i, j])
    enemy = sorted(enemy, key=lambda x: (-x[0], x[1]))

    for position in per:
        archers = get_archers(position, n)
        game_enemy = copy.deepcopy(enemy)
        kill = 0

        while game_enemy:
            game_enemy, kill_num = turn_archer(
                game_enemy, archers, max_distance)
            game_enemy = turn_enenmy(game_enemy, n)
            kill += kill_num

        max_kill = max(max_kill, kill)

    print(max_kill)


if __name__ == "__main__":
    main()
