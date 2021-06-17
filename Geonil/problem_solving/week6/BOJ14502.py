# 연구소
import sys
import copy
from collections import deque
from itertools import combinations
In = sys.stdin.readline

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

virus = 2
wall = 1
blank = 0


def check_safezone(lab):
    cnt = 0
    for sub in lab:
        cnt += sub.count(0)
    return cnt


def bfs(lab):
    n = len(lab)
    m = len(lab[0])
    visited = [[0]*m for _ in range(n)]
    queue = deque()

    for i in range(n):
        for j in range(m):
            if lab[i][j] == virus:
                for mx, my in zip(dx, dy):
                    next_x = i + mx
                    next_y = j + my
                    if 0 <= next_x < n and 0 <= next_y < m:
                        if not visited[next_x][next_y] and lab[next_x][next_y] == blank:
                            visited[next_x][next_y] = True
                            queue.append([next_x, next_y])

    while len(queue):
        x, y = queue.popleft()
        lab[x][y] = virus

        for mx, my in zip(dx, dy):
            next_x = x + mx
            next_y = y + my
            if 0 <= next_x < n and 0 <= next_y < m:
                if not visited[next_x][next_y] and lab[next_x][next_y] == blank:
                    visited[next_x][next_y] = True
                    queue.append([next_x, next_y])


def brute_force(lab, blank_location):
    cases = list(combinations(blank_location, 3))
    max_safezone = 0

    for case in cases:
        tmp_map = copy.deepcopy(lab)

        for x, y in case:
            tmp_map[x][y] = 1

        bfs(tmp_map)
        max_safezone = max(max_safezone, check_safezone(tmp_map))

    print(max_safezone)


def main():
    n, m = map(int, In().split())
    lab = []
    blank_location = []
    for i in range(n):
        sub = list(map(int, In().split()))
        for j in range(m):
            if sub[j] == 0:
                blank_location.append([i, j])
        lab.append(sub)

    brute_force(lab, blank_location)


if __name__ == "__main__":
    main()
