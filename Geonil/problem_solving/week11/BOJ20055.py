# 컨베이어 벨트 위의 로봇
import sys
from collections import deque
In = sys.stdin.readline


def get_duration(belts):
    cnt = 0
    for duration in belts:
        if duration == 0:
            cnt += 1

    return cnt


def rotation(robots, n, start, finish):
    if start == 0:
        start = 2*n-1
        finish -= 1
    elif finish == 0:
        finish = 2*n-1
        start -= 1
    else:
        start -= 1
        finish -= 1

    if robots:
        if robots[0] == finish:
            robots.popleft()

    return start, finish


def phases(belts, robots, start, finish):
    n = len(belts)//2

    new_robots = deque()

    for robot in robots:
        n_pos = robot + 1
        if n_pos == 2 * n:
            n_pos = 0
        if belts[n_pos] != 0 and n_pos not in new_robots:
            if n_pos != finish:
                new_robots.append(n_pos)
            belts[n_pos] -= 1
        else:
            new_robots.append(robot)

    if belts[start] != 0:
        new_robots.append(start)
        belts[start] -= 1

    return new_robots


def main():
    n, k = map(int, In().split())
    belts = list(map(int, In().split()))
    robots = deque()

    phase = 0
    duration = 0
    start = 0
    finish = n-1

    while duration < k:
        start, finish = rotation(robots, n, start, finish)
        robots = phases(belts, robots, start, finish)
        phase += 1
        duration = get_duration(belts)

    print(phase)


if __name__ == "__main__":
    main()
