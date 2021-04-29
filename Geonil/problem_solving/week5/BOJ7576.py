import sys
from collections import deque
In = sys.stdin.readline


def check_done(house):
    return not any(0 in sub for sub in house)


def bfs(house, n, m):
    visited = [[0 for _ in range(m)] for _ in range(n)]
    x = [-1, 1, 0, 0]
    y = [0, 0, -1, 1]
    day = 0
    check_tomato = 0

    queue = deque()

    if check_done(house):
        return 0

    for i in range(n):
        for j in range(m):
            if house[i][j] == 1 and visited[i][j] == 0:
                for mx, my in zip(x, y):
                    next_x = i + mx
                    next_y = j + my

                    if 0 <= next_x and next_x < n and 0 <= next_y and next_y < m:
                        if house[next_x][next_y] == 0 and visited[next_x][next_y] == 0:
                            house[next_x][next_y] = 1
                            visited[next_x][next_y] = 1
                            queue.append([next_x, next_y])

    day += 1
    divider = len(queue)

    while True:
        if len(queue) == 0:
            break

        start_x, start_y = map(int, queue.popleft())
        check_tomato += 1

        for mx, my in zip(x, y):
            next_x = start_x + mx
            next_y = start_y + my

            if 0 <= next_x and next_x < n and 0 <= next_y and next_y < m:
                if house[next_x][next_y] == 0 and visited[next_x][next_y] == 0:
                    house[next_x][next_y] = 1
                    visited[next_x][next_y] = 1
                    queue.append([next_x, next_y])

        if divider == check_tomato:
            divider = len(queue)
            check_tomato = 0
            day += 1

    if not check_done(house):
        return -1
    else:
        return day-1


def main():
    m, n = map(int, In().split())
    house = []

    for _ in range(n):
        house.append(list(map(int, In().rstrip().split())))

    print(bfs(house, n, m))


main()
