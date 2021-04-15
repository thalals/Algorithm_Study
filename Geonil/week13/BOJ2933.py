# 미네랄
'''
시간초과
DFS => BFS
'''
import sys
from collections import deque, defaultdict
In = sys.stdin.readline

clusters = []
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]

r, c = map(int, In().split())
cave = []
for _ in range(r):
    sub = list(map(str, In().rstrip()))
    cave.append(sub)

num = int(In())
sticks = list(map(int, In().split()))


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


def falling(d_dict):
    v = sorted(clusters, reverse=True)

    height = r
    for y, x in d_dict.items():
        height = min(get_fall(x, y), height)

    for x, y in v:
        cave[x][y] = '.'
        cave[x+height][y] = 'x'


def bfs(start):
    queue = deque()
    d_dict = defaultdict(int)

    visited = [[0] * c for _ in range(r)]
    visited[start[0]][start[1]] = 1
    clusters.append(start)
    queue.append(start)

    while queue:
        x, y = queue.popleft()

        if d_dict[y] < x:
            d_dict[y] = x

        if x == r-1:
            return

        for nx, ny in zip(dx, dy):
            new_x, new_y = x+nx, y+ny
            if check(new_x, new_y):
                if cave[new_x][new_y] == 'x' and not visited[new_x][new_y]:
                    if new_x == r-1:
                        return
                    visited[new_x][new_y] = 1
                    clusters.append([new_x, new_y])
                    queue.append([new_x, new_y])

    falling(d_dict)


def throw(stick: int, turn: int):
    height = r - stick

    if turn:    # left
        for i in range(c):
            if cave[height][i] == 'x':
                break
    else:       # right
        for i in range(c-1, -1, -1):
            if cave[height][i] == 'x':
                break

    cave[height][i] = '.'
    x, y = height, i

    for nx, ny in zip(dx, dy):
        new_x, new_y = x+nx, y+ny
        if check(new_x, new_y):
            if cave[new_x][new_y] == 'x':
                clusters.clear()
                bfs([new_x, new_y])


def main():
    turn: int = 1
    for stick in sticks:
        throw(stick, turn)
        turn = abs(turn-1)

    for row in cave:
        print(''.join(row))


if __name__ == "__main__":
    main()
