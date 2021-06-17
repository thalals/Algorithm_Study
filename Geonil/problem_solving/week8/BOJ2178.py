import sys
from collections import deque

In = sys.stdin.readline
moves = [[0, 1], [1, 0], [-1, 0], [0, -1]]

n, m = map(int, In().split())
maze = []
for _ in range(n):
    sub_lst = list(map(str, In().rstrip()))
    maze.append(sub_lst)

visited = [[0]*100 for _ in range(100)]


def check_possible(x, y):
    if 0 <= x < n and 0 <= y < m:
        if maze[x][y] == '1' and not visited[x][y]:
            return True
    return False


def bfs():
    queue = deque()
    start = [0, 0, 1]

    queue.append(start)
    visited[0][0] = 1

    while queue:
        x, y, cnt = queue.popleft()
        for move in moves:
            dx, dy = move
            new_x = x + dx
            new_y = y + dy
            new_cnt = cnt + 1
            if new_x == n-1 and new_y == m-1:
                return new_cnt
            if check_possible(new_x, new_y):
                new_data = [new_x, new_y, new_cnt]
                queue.append(new_data)
                visited[new_x][new_y] = new_cnt


def main():
    print(bfs())


if __name__ == "__main__":
    main()
