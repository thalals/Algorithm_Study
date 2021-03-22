# 캐슬 디펜스
import sys
import copy
from itertools import permutations
In = sys.stdin.readline


def get_distance(point1, point2):
    return abs(point1[0]-point2[0]) + abs(point1[1]-point2[1])


def get_archers(cols, n):
    archers = []
    for c in cols:
        archers.append([n, c])

    return archers


def check_over(grid):
    for rows in grid:
        if 1 in rows:
            return False

    return True


def turn_archer(grid, archers, max_distance, n, m):
    kills = []
    for archer in archers:
        distance = 100
        kill = False

        for j in range(m):
            for i in range(n):
                if grid[i][j] == 1:
                    dist = get_distance(archer, [i, j])

                    if dist < distance and dist <= max_distance:
                        distance = dist
                        kill = [i, j]
        if kill:
            if kill not in kills:
                kills.append(kill)

    for kill in kills:
        x, y = kill
        grid[x][y] = 0

    return len(kills)


def turn_enemy(grid, n, m):
    for i in range(n-1, -1, -1):
        for j in range(m):
            if i == n-1:
                if grid[i][j] == 1:
                    grid[i][j] = 0
            else:
                if grid[i][j] == 1:
                    grid[i][j] = 0
                    grid[i+1][j] = 1


def main():
    n, m, max_distance = map(int, In().split())
    grid = []
    max_kill = 0

    per = list(permutations(range(m), 3))

    for _ in range(n):
        sub = list(map(int, In().split()))
        grid.append(sub)

    for position in per:
        archers = get_archers(position, n)
        game_grid = copy.deepcopy(grid)
        kill = 0

        while not check_over(game_grid):
            kill += turn_archer(game_grid, archers, max_distance, n, m)
            turn_enemy(game_grid, n, m)

        max_kill = max(max_kill, kill)

    print(max_kill)


if __name__ == "__main__":
    main()
