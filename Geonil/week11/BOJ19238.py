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

dest = [[] for _ in range(m+2)]
for i in range(m):
    tmp = list(map(int, In().split()))
    maps[tmp[0]-1][tmp[1]-1] = i+2
    dest[i+2] = [tmp[2], tmp[3]]


def check(x, y):
    if 0 <= x-1 < len(maps) and 0 <= y-1 < len(maps):
        if maps[x-1][y-1] != 1:
            return True

    return False


def search_passenger(now):
    visited = []
    queue = deque()
    queue.append([now, 0])
    visited.append(now)

    while queue:
        length = len(queue)
        person = []

        for _ in range(length):
            position, distance = queue.popleft()
            x, y = position

            if maps[x-1][y-1] > 1:
                person.append([x, y])

            for move in moves:
                dx, dy = move
                new_x, new_y = x+dx, y+dy
                if check(new_x, new_y) and [new_x, new_y] not in visited:
                    queue.append([[new_x, new_y], distance + 1])
                    visited.append([new_x, new_y])

        if person:
            person.sort()
            return person[0], distance

    return -1, -1


def move_taxi(now, target):
    visited = []
    queue = deque()
    queue.append([now, 0])
    visited.append(now)

    while queue:
        position, distance = queue.popleft()
        x, y = position
        if [x, y] == target:
            return distance

        for move in moves:
            dx, dy = move
            new_x, new_y = x+dx, y+dy
            if check(new_x, new_y) and [new_x, new_y] not in visited:
                queue.append([[new_x, new_y], distance+1])
                visited.append([new_x, new_y])

    return -1


def main():
    global taxi
    global fuel
    global m

    cnt = 0

    while True:
        if cnt == m:
            break

        person, distance = search_passenger(taxi)
        if distance == -1:
            print(-1)
            return

        x, y = person
        destination = maps[x-1][y-1]
        maps[x-1][y-1] = 0
        fuel -= distance
        taxi = [x, y]

        use = move_taxi(taxi, dest[destination])
        if use == -1:
            print(-1)
            return

        fuel -= use
        taxi = dest[destination]

        if fuel < 0:
            break

        cnt += 1
        fuel += use*2

    if fuel < 0:
        print(-1)
    else:
        print(fuel)


if __name__ == "__main__":
    main()
