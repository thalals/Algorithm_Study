"""
problem : 치킨배달 (BOJ 15686)
comment : 0빈, 1집, 2치 combinations
"""
import sys
from itertools import combinations

In = sys.stdin.readline

moves = [(0, 1), (0, -1), (1, 0), (-1, 0)]

N, M = map(int, In().split())
city = []
for _ in range(N):
    city.append(list(map(int, In().split())))

distances = [[[] for _ in range(N)] for _ in range(N)]


def main():
    chickens = []
    houses = []
    answer = float("inf")

    for i in range(N):
        for j in range(N):
            if city[i][j] == 2:
                chickens.append([i, j])
            if city[i][j] == 1:
                houses.append([i, j])

    open_chickens = list(combinations(chickens, M))
    for open_c in open_chickens:
        distances = 0
        for x, y in houses:
            distance = float("inf")
            for cx, cy in open_c:
                distance = min(distance, abs(x - cx) + abs(y - cy))
            distances += distance
        answer = min(answer, distances)

    print(answer)


if __name__ == "__main__":
    main()
