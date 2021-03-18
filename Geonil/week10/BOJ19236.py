# 청소년 상어
import sys
import copy
In = sys.stdin.readline
sys.setrecursionlimit(10**6)
# ↑, ↖, ←, ↙, ↓, ↘, →, ↗
# 1,  2, 3,  4, 5,  6, 7, 8

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


def recursion(fishes, spaces, die, ans):
    global answer

    new_fishes = copy.deepcopy(fishes)
    new_spaces = copy.deepcopy(spaces)
    new_die = copy.deepcopy(die)

    # fish moving
    for i in range(1, 17):
        if i in die:
            continue

        direction = new_fishes[i][0]
        pos_x, pos_y = new_fishes[i][1]
        dx, dy = direct[direction-1]
        new_x, new_y = pos_x+dx, pos_y+dy

        cnt = 1

        while True:
            if 0 <= new_x < 4 and 0 <= new_y < 4 and new_spaces[new_x][new_y] != 0:
                break
            if cnt == 9:
                break
            rotate(new_fishes, i)
            direction = new_fishes[i][0]
            dx, dy = direct[direction-1]
            new_x, new_y = pos_x+dx, pos_y+dy
            cnt += 1

        if 0 <= new_x < 4 and 0 <= new_y < 4 and new_spaces[new_x][new_y] != 0:
            if new_spaces[new_x][new_y] != -1:
                fish = new_spaces[new_x][new_y]
                new_fishes[fish][1] = [pos_x, pos_y]
                new_fishes[i][1] = [new_x, new_y]
                new_spaces[new_x][new_y] = i
                new_spaces[pos_x][pos_y] = fish
            else:
                new_fishes[i][1] = [new_x, new_y]
                new_spaces[new_x][new_y] = i
                new_spaces[pos_x][pos_y] = -1

    # shark moving
    spos_x, spos_y = new_fishes[0][1]
    sdirection = new_fishes[0][0]
    dx, dy = direct[sdirection-1]
    snew_x, snew_y = spos_x+dx, spos_y+dy
    moving = []

    while True:
        if snew_x < 0 or 4 <= snew_x or snew_y < 0 or 4 <= snew_y:
            break

        if new_spaces[snew_x][snew_y] != -1:
            moving.append([snew_x, snew_y])

        snew_x, snew_y = snew_x+dx, snew_y+dy

    if not moving:
        print(ans)
        answer = max(answer, ans)
        return

    for item in moving:
        snew_x, snew_y = item
        eating = new_spaces[snew_x][snew_y]
        new_die.append(eating)
        new_ans = ans + eating
        new_fishes[0] = new_fishes[eating]
        new_spaces[spos_x][spos_y] = -1
        new_spaces[snew_x][snew_y] = 0  # shark
        recursion(new_fishes, new_spaces, new_die, new_ans)


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
    spaces[0][0] = 0  # shark

    recursion(fishes, spaces, die, ans)
    print(answer)

    # while True:
    #     for i in range(4):
    #         for j in range(4):
    #             print(spaces[i][j], end=' ')
    #         print()
    #     print()

    #     # fish moving
    #     for i in range(1, 17):
    #         # i fish moving

    #         if i in die:
    #             continue

    #         direction = fishes[i][0]
    #         pos_x, pos_y = fishes[i][1]
    #         dx, dy = direct[direction-1]
    #         new_x, new_y = pos_x+dx, pos_y+dy

    #         cnt = 1

    #         while True:
    #             if 0 <= new_x < 4 and 0 <= new_y < 4 and spaces[new_x][new_y] != 0:
    #                 break
    #             if cnt == 9:
    #                 break
    #             rotate(fishes, i)
    #             direction = fishes[i][0]
    #             dx, dy = direct[direction-1]
    #             new_x, new_y = pos_x+dx, pos_y+dy
    #             cnt += 1

    #         if 0 <= new_x < 4 and 0 <= new_y < 4 and spaces[new_x][new_y] != 0:
    #             if spaces[new_x][new_y] != -1:
    #                 fish = spaces[new_x][new_y]
    #                 fishes[fish][1] = [pos_x, pos_y]
    #                 fishes[i][1] = [new_x, new_y]
    #                 spaces[new_x][new_y] = i
    #                 spaces[pos_x][pos_y] = fish
    #             else:
    #                 fishes[i][1] = [new_x, new_y]
    #                 spaces[new_x][new_y] = i
    #                 spaces[pos_x][pos_y] = -1

    #     print(fishes[0])
    #     print(fishes)
    #     print('finish fish moving!')
    #     for i in range(4):
    #         for j in range(4):
    #             print(spaces[i][j], end=' ')
    #         print()
    #     print()
    #     # shark moving
    #     spos_x, spos_y = fishes[0][1]
    #     sdirection = fishes[0][0]
    #     dx, dy = direct[sdirection-1]
    #     snew_x, snew_y = spos_x+dx, spos_y+dy
    #     moving = []
    #     num = []

    #     while True:
    #         if snew_x < 0 or 4 <= snew_x or snew_y < 0 or 4 <= snew_y:
    #             break

    #         if spaces[snew_x][snew_y] != -1:
    #             moving.append([spaces[snew_x][snew_y], [snew_x, snew_y]])

    #         snew_x, snew_y = snew_x+dx, snew_y+dy

    #     if not moving:
    #         break

    #     moving = sorted(moving, key=lambda x: x[0], reverse=True)
    #     print('moving:', moving)
    #     idx = 0
    #     for i, item in enumerate(moving):
    #         n = item[0]
    #         x, y = item[1]
    #         dx, dy = direct[fishes[n][0]-1]
    #         nx, ny = x+dx, y+dy

    #         if 0 <= nx < 4 and 0 <= ny < 4:
    #             idx = i
    #             break

    #     snew_x, snew_y = moving[idx][1]

    #     eating = spaces[snew_x][snew_y]
    #     die.append(eating)
    #     ans += eating
    #     fishes[0] = fishes[eating]
    #     spaces[spos_x][spos_y] = -1
    #     spaces[snew_x][snew_y] = 0  # shark

    # print(ans)


if __name__ == "__main__":
    main()
