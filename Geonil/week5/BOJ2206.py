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

visited = [[False]*M for _ in range(N)]
dx = [1, 0, 0, -1]
dy = [0, 1, -1, 0]


def can_go(x, y):
    for mx, my in zip(dx, dy):
        nx = x + mx
        ny = y + my
        if not visited[nx][ny] and mapping[nx][ny] == 0:
            return True
    return False


def BFS(x, y):
    queue = deque()


def main():
    print(BFS(0, 0))


if __name__ == "__main__":
    main()
