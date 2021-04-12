# 미네랄
import sys
In = sys.stdin.readline

visited = []
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

r, c = map(int, In().split())
cave = []
for _ in range(r):
    sub = list(map(str, In().rstrip()))
    cave.append(sub)

num = int(In())
sticks = list(map(int, In().split()))

# 공중에 떳는지 확인


def print_cave():
    for i in range(r):
        for j in range(c):
            print(cave[i][j], end='')
        print()
    print()


def check(x, y):
    if 0 <= x < r and 0 <= y < c:
        return True
    return False


def dfs(start):

    visited.append(start)
    x, y = start

    if x == r-1:
        return False

    for nx, ny in zip(dx, dy):
        new_x, new_y = x+nx, y+ny
        if check(new_x, new_y):
            if cave[new_x][new_y] == 'x' and [new_x, new_y] not in visited:
                if new_x == r-1:
                    return False
                return dfs([new_x, new_y])

    return True


def check_cluster(start):
    x, y = start
    visited.clear()

    if dfs(start):
        # fall
        print('fall!')


def throw(stick: int, turn: int):
    height = r - stick
    if turn:  # left
        for i in range(c):
            if cave[height][i] == 'x':
                break
    else:
        for i in range(c-1, 0, -1):
            if cave[height][i] == 'x':
                break
    cave[height][i] = '.'
    x, y = height, i

    print_cave()

    for nx, ny in zip(dx, dy):
        new_x, new_y = x+nx, y+ny
        if check(new_x, new_y):
            if cave[new_x][new_y] == 'x':
                check_cluster([new_x, new_y])


def main():

    turn: int = 1
    for stick in sticks:
        throw(stick, turn)
        turn = abs(turn-1)


if __name__ == "__main__":
    main()
