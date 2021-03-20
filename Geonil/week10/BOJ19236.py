# 청소년 상어
import sys
import copy
In = sys.stdin.readline
sys.setrecursionlimit(10**6)
'''
== direction ==
↑, ↖, ←, ↙, ↓, ↘, →, ↗
1,  2, 3,  4, 5,  6, 7, 8

== numbering ==
blank : -1
shark : 0
'''

direct = [
    [-1, 0],
    [-1, -1],
    [0, -1],
    [1, -1],
    [1, 0],
    [1, 1],
    [0, 1],
    [-1, 1]
]

answer = 0


def rotate(fishes, num):
    if fishes[num][0] < 8:
        fishes[num][0] += 1
    else:
        fishes[num][0] = 1


def fish_moving(fishes, spaces, die):
    for i in range(1, 17):
        if i in die:
            continue

        direction = fishes[i][0]
        pos_x, pos_y = fishes[i][1]
        dx, dy = direct[direction-1]
        new_x, new_y = pos_x + dx, pos_y + dy

        while True:
            if 0 <= new_x < 4 and 0 <= new_y < 4 and spaces[new_x][new_y] != 0:
                break

            rotate(fishes, i)
            direction = fishes[i][0]
            dx, dy = direct[direction-1]
            new_x, new_y = pos_x + dx, pos_y + dy

        if 0 <= new_x < 4 and 0 <= new_y < 4 and spaces[new_x][new_y] != 0:
            if spaces[new_x][new_y] != -1:
                fish = spaces[new_x][new_y]
                fishes[fish][1] = [pos_x, pos_y]
                fishes[i][1] = [new_x, new_y]
                spaces[new_x][new_y] = i
                spaces[pos_x][pos_y] = fish
            else:
                fishes[i][1] = [new_x, new_y]
                spaces[new_x][new_y] = i
                spaces[pos_x][pos_y] = -1


def recursion(fishes, spaces, die, ans):
    global answer

    fish_moving(fishes, spaces, die)

    spos_x, spos_y = fishes[0][1]
    sdirection = fishes[0][0]
    dx, dy = direct[sdirection-1]
    snew_x, snew_y = spos_x+dx, spos_y+dy
    moving = []

    while True:
        if snew_x < 0 or 4 <= snew_x or snew_y < 0 or 4 <= snew_y:
            break

        if spaces[snew_x][snew_y] != -1:
            moving.append([snew_x, snew_y])

        snew_x, snew_y = snew_x+dx, snew_y+dy

    if not moving:
        answer = max(answer, ans)
        return

    for item in moving:
        n_spaces = copy.deepcopy(spaces)
        n_fishes = copy.deepcopy(fishes)
        n_die = copy.deepcopy(die)

        snew_x, snew_y = item
        eating = spaces[snew_x][snew_y]
        n_die.append(eating)
        new_ans = ans + eating
        n_fishes[0] = fishes[eating]
        n_spaces[spos_x][spos_y] = -1
        n_spaces[snew_x][snew_y] = 0

        recursion(n_fishes, n_spaces, n_die, new_ans)


def main():
    global answer

    fishes = [0]*17
    spaces = [[0]*4 for _ in range(4)]
    die = []

    for i in range(4):
        sub = list(map(int, In().split()))
        for j in range(0, 7, 2):
            spaces[i][j//2] = sub[j]
            fishes[sub[j]] = [sub[j+1], [i, j//2]]

    ans = 0

    eating = spaces[0][0]
    die.append(eating)
    ans += eating
    fishes[0] = fishes[eating]
    spaces[0][0] = 0

    recursion(fishes, spaces, die, ans)
    print(answer)


if __name__ == "__main__":
    main()
