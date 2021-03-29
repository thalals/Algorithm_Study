# 스타트 택시
import sys
from collections import deque
In = sys.stdin.readline

moves = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1]
]

n, m, fuel = map(int, In().split())
maps = []
for _ in range(n):
    sub = list(map(int, In().split()))
    maps.append(sub)
taxi = list(map(int, In().split()))

passengers = []
for _ in range(m):
    tmp = list(map(int, In().split()))
    passenger = [tmp[:2], tmp[2:]]
    passengers.append(passenger)
passengers = sorted(passengers, key=lambda x: (x[0][0], x[0][1]))


def check_pos(x, y):
    if 0 <= x-1 < len(maps) and 0 <= y-1 < len(maps):
        if maps[x-1][y-1] != 1:
            return True
    return False


def bfs(now, target):
    visited = []

    queue = deque()
    queue.append([now, 0])
    visited.append(now)

    while queue:
        pos, distance = queue.popleft()

        if pos == target:
            return distance

        for move in moves:
            x, y = pos
            dx, dy = move
            new_x, new_y = x+dx, y+dy
            if [new_x, new_y] not in visited:
                if check_pos(new_x, new_y):
                    queue.append([[new_x, new_y], distance+1])
                    visited.append([new_x, new_y])


def main():
    global taxi
    global fuel

    while True:
        distance = 100
        for idx, passenger in enumerate(passengers):
            d = bfs(taxi, passenger[0])
            if d < distance:
                distance = d
                p = idx

        fuel -= distance
        use = bfs(taxi, passengers[idx][1])
        fuel -= use
        taxi = passengers[idx][1]

        passengers.remove(passengers[p])

        if fuel < 0:
            break

        fuel += use*2

        if not passengers:
            break

    if fuel < 0:
        print(-1)
    else:
        print(fuel)


if __name__ == "__main__":
    main()
