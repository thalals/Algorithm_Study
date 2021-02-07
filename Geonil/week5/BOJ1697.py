import sys
from collections import deque, defaultdict
In = sys.stdin.readline

N, K = map(int, In().split())
visited = defaultdict()


def walk(n):
    return n-1, n+1


def bfs(start, target):
    queue = deque()

    queue.append(target)
    visited[target] = False
    time = 0
    sync = 0
    division = 1

    while True:
        now = queue.popleft()
        sync += 1

        if now == start:
            return time

        if now % 2 == 0:  # and now // 2 >= start:
            next1 = now // 2
            next2 = -1
        else:
            next1, next2 = walk(now)

        if 0 <= next1:
            if not next1 in visited:
                visited[next1] = True
                queue.append(next1)
        if 0 <= next2 and next2 <= 100000:
            if not next2 in visited:
                visited[next2] = True
                queue.append(next2)

        if division == sync:
            division = len(queue)
            sync = 0
            time += 1


def main():
    print(bfs(N, K))


main()
