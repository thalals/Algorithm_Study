import sys
from collections import defaultdict

In = sys.stdin.readline
size = 19
moves = [[1, 1], [-1, 1], [0, 1], [1, 0]]


def check_win(locations):
    visited = defaultdict(list)

    for location in locations:
        x, y = location

        for flag, move in enumerate(moves):
            if [x, y] in visited[flag]:
                continue
            cnt = 1
            visited[flag].append([x, y])
            dx, dy = move
            next_x = x + dx
            next_y = y + dy

            while True:
                if [next_x, next_y] in locations and [next_x, next_y] not in visited[flag]:
                    cnt += 1
                    visited[flag].append([next_x, next_y])
                    next_x = next_x + dx
                    next_y = next_y + dy
                else:
                    break

            if cnt == 5:
                return True, location

    return False, 0


def main():
    black_map = []
    white_map = []

    for i in range(1, size+1):
        sub_map = list(map(int, In().split()))
        for j in range(len(sub_map)):
            if sub_map[j] == 1:
                black_map.append([i, j+1])
            elif sub_map[j] == 2:
                white_map.append([i, j+1])

    black_map.sort(key=lambda x: (x[1], x[0]))
    white_map.sort(key=lambda x: (x[1], x[0]))

    b_win, loc = check_win(black_map)
    print(black_map)

    if b_win:
        print(1)
        print(loc[0], loc[1])
    else:
        w_win, loc = check_win(white_map)
        if w_win:
            print(2)
            print(loc[0], loc[1])
        else:
            print(0)


if __name__ == "__main__":
    main()
