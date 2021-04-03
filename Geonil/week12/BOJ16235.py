# 나무 재태크
import sys
from collections import deque
In = sys.stdin.readline

dx = [0, 1, 0, -1, 1, -1, 1, -1]
dy = [1, 0, -1, 0, 1, 1, -1, -1]


def check(x, y, n):
    if 0 <= x-1 < n and 0 <= y-1 < n:
        return True
    return False


class Wood():
    def __init__(self, n: int) -> None:
        self.n = n
        self.grounds = [[5]*self.n for _ in range(self.n)]
        self.adds = []
        self.woods = deque()
        self.died = []

    def set(self, m):
        for _ in range(self.n):
            sub = list(map(int, In().split()))
            self.adds.append(sub)

        for _ in range(m):
            wood = list(map(int, In().split()))
            self.woods.append(wood)

    def spring(self):
        self.woods = deque(sorted(self.woods))
        length = len(self.woods)

        for _ in range(length):
            wood = self.woods.popleft()
            x, y, age = wood
            if self.grounds[x-1][y-1] < age:
                self.died.append(wood)
            else:
                self.grounds[x-1][y-1] -= age
                wood = [x, y, age+1]
                self.woods.append(wood)

    def summer(self):
        for wood in self.died:
            x, y, age = wood
            self.grounds[x-1][y-1] += age//2
        self.died = []

    def fall(self):
        length = len(self.woods)
        for i in range(length):
            x, y, age = self.woods[i]

            if age % 5 == 0:
                for j in range(8):
                    new_x, new_y = x+dx[j], y+dy[j]
                    if check(new_x, new_y, self.n):
                        wood = [new_x, new_y, 1]
                        self.woods.append(wood)

    def winter(self):
        for i in range(self.n):
            for j in range(self.n):
                self.grounds[i][j] += self.adds[i][j]

    def solutions(self, k):
        for _ in range(k):
            self.spring()
            self.summer()
            self.fall()
            self.winter()

        return len(self.woods)


def main():
    n, m, k = map(int, In().split())
    zettak = Wood(n)
    zettak.set(m)
    answer = zettak.solutions(k)
    print(answer)


if __name__ == "__main__":
    main()
