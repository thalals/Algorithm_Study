"""
problem : 호석이 두마리 치킨 (BOJ )
comment : bfs 이용
"""
import sys
from collections import defaultdict, deque
from itertools import combinations

In = sys.stdin.readline

N, M = map(int, In().split())
road = defaultdict(list)
for _ in range(M):
    i, j = map(int, In().split())
    road[i - 1].append(j - 1)
    road[j - 1].append(i - 1)


def search(x, distances):
    visited = [False for _ in range(N)]
    queue = deque()

    queue.append([x, 0])
    visited[x] = True
    distances[x] = 0

    while True:
        if not queue:
            break
        x, dis = queue.popleft()

        distances[x] = min(distances[x], dis)

        for n in road[x]:
            if not visited[n]:
                visited[n] = True
                queue.append([n, dis + 2])


def main():
    city = [i for i in range(N)]

    combs = list(combinations(city, 2))
    answer = float("inf")

    for select in combs:
        distances = [float("inf") for _ in range(N)]
        for n in select:
            search(n, distances)
        if answer > sum(distances):
            answer = sum(distances)
            i, j = select

    print(i + 1, j + 1, answer)


if __name__ == "__main__":
    main()
