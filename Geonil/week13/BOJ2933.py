# 미네랄
'''
시간초과
'''
import sys
sys.setrecursionlimit(10**6)
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


def print_cave():
    for i in range(r):
        for j in range(c):
            print(cave[i][j], end='')
        print()


def check(x, y):
    if 0 <= x < r and 0 <= y < c:
        return True
    return False


def get_fall(x, y):
    height = 0

    while True:
        if check(x+1, y):
            x += 1
            if cave[x][y] == 'x':
                return height
            height += 1
        else:
            return height


def falling():
    clusters = sorted(visited, reverse=True)
    col = []
    under = []

    for x, y in clusters:
        if y not in col:
            col.append(y)
            under.append([x, y])

    height = r
    for x, y in under:
        height = min(get_fall(x, y), height)

    if height == 0:
        return

    for x, y in clusters:
        cave[x][y] = '.'
        cave[x+height][y] = 'x'


def dfs(start):
    visited.append(start)
    x, y = start

    for nx, ny in zip(dx, dy):
        new_x, new_y = x+nx, y+ny
        if check(new_x, new_y):
            if cave[new_x][new_y] == 'x' and [new_x, new_y] not in visited:
                dfs([new_x, new_y])


def check_cluster(start):
    x, y = start
    visited.clear()

    dfs(start)
    falling()


def throw(stick: int, turn: int):
    height = r - stick
    if turn:    # left
        for i in range(c):
            if cave[height][i] == 'x':
                break
    else:       # right
        for i in range(c-1, 0, -1):
            if cave[height][i] == 'x':
                break
    cave[height][i] = '.'
    x, y = height, i

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

    print_cave()


if __name__ == "__main__":
    main()
