import sys
from collections import deque
In = sys.stdin.readline

N, M = map(int, In().split())
mapping = []

for i in range(N):
    sub_lst = []
    for j in range(M):
        sub_lst.append(int(sys.stdin.read(1)))
    sys.stdin.read(1)
    mapping.append(sub_lst)

visited = [[[0]*2 for _ in range(M)] for _ in range(N)]

dx = [1, 0, 0, -1]
dy = [0, 1, -1, 0]


def BFS():
    queue = deque()
    visited[0][0][0] = True
    # x, y, wall, cnt
    queue.append([0, 0, 0, 1])

    while True:
        if len(queue) == 0:
            break
        x, y, wall, cnt = queue.popleft()
        if x == N-1 and y == M-1:
            return cnt

        for mx, my in zip(dx, dy):
            nx = mx + x
            ny = my + y

            if 0 <= nx < N and 0 <= ny < M:
                if mapping[nx][ny] == 0 and visited[nx][ny][wall] == 0:
                    visited[nx][ny][wall] = 1
                    queue.append([nx, ny, wall, cnt + 1])
                elif mapping[nx][ny] == 1 and not wall and visited[nx][ny][1] == 0:
                    visited[nx][ny][wall] = 1
                    queue.append([nx, ny, True, cnt + 1])
    return -1


def main():
    print(BFS())


if __name__ == "__main__":
    main()
