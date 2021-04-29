import sys
from collections import deque, defaultdict
In = sys.stdin.readline

N, K = map(int, In().split())
visited = defaultdict()


def walk(n):
    return n+1, n-1


def bfs(start, target):
    queue = deque()

    queue.append(start)
    visited[start] = False
    time = 0
    sync = 0
    division = 1

    while True:
        now = queue.popleft()
        sync += 1

        if now == target:
            return time

        next1 = 2*now
        next2, next3 = walk(now)

        if next1 <= 100000:
            if not next1 in visited:
                visited[next1] = True
                queue.append(next1)
        if next2 <= 100001:
            if not next2 in visited:
                visited[next2] = True
                queue.append(next2)
        if 0 <= next3:
            if not next3 in visited:
                visited[next3] = True
                queue.append(next3)

        if division == sync:
            division = len(queue)
            sync = 0
            time += 1


def main():
    print(bfs(N, K))


main()
