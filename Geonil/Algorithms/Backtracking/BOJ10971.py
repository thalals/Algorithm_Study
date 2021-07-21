"""
problem : 외판원 순회 2 (BOJ 10971)
comment : 
"""
import sys
from itertools import permutations
from typing import ForwardRef

In = sys.stdin.readline
N = int(In())
weights = []
for _ in range(N):
    weights.append(list(map(int, In().split())))
answer = float("inf")

visited = [False for _ in range(N)]


def dfs(start, city, cnt, cost):
    global answer

    if city == start and cnt == N:
        answer = min(answer, cost)
        return

    for i in range(N):
        if weights[city][i] == 0:
            continue

        if not visited[i]:
            visited[i] = True

            cost += weights[city][i]
            if cost <= answer:
                dfs(start, i, cnt + 1, cost)

            visited[i] = False
            cost -= weights[city][i]


def main():
    for i in range(N):
        dfs(i, i, 0, 0)

    print(answer)


if __name__ == "__main__":
    main()
