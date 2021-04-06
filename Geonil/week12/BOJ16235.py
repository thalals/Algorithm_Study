# 나무 재태크
import sys
from collections import deque
In = sys.stdin.readline

dx = [0, 1, 0, -1, 1, -1, 1, -1]
dy = [1, 0, -1, 0, 1, 1, -1, -1]


def check(x, y, n: int):
    if 0 <= x < n and 0 <= y < n:
        return True
    return False


class Wood():
    def __init__(self, n: int):
        self.n = n
        self.grounds = [[5]*self.n for _ in range(self.n)]
        self.woods = [[deque() for _ in range(self.n)] for _ in range(self.n)]
        self.dead = [[0]*self.n for _ in range(self.n)]
        self.adds = []
        self.cnt = 0

    def set(self, m: int):
        for _ in range(self.n):
            sub = list(map(int, In().split()))
            self.adds.append(sub)

        for _ in range(m):
            x, y, age = map(int, In().split())
            self.woods[x-1][y-1].append(age)
            self.cnt += 1

    def spring_and_summer(self):
        for r in range(self.n):
            for c in range(self.n):
                wood = self.woods[r][c]
                new_wood = deque()

                for age in wood:
                    if self.grounds[r][c] < age:
                        self.dead[r][c] += age//2
                        self.cnt -= 1
                    else:
                        self.grounds[r][c] -= age
                        new_wood.append(age+1)

                self.woods[r][c] = new_wood

                self.grounds[r][c] += self.dead[r][c]
                self.dead[r][c] = 0

    def fall_and_winter(self):
        for r in range(self.n):
            for c in range(self.n):
                wood = self.woods[r][c]

                for age in wood:
                    if age % 5 == 0:
                        for i in range(8):
                            new_x, new_y = r+dx[i], c+dy[i]
                            if check(new_x, new_y, self.n):
                                self.woods[new_x][new_y].appendleft(1)
                                self.cnt += 1

                self.grounds[r][c] += self.adds[r][c]

    def solutions(self, k: int):
        for _ in range(k):
            self.spring_and_summer()
            self.fall_and_winter()
            if self.cnt == 0:
                break

        return self.cnt


def main():
    n, m, k = map(int, In().split())
    zettak = Wood(n)
    zettak.set(m)
    answer = zettak.solutions(k)
    print(answer)


if __name__ == "__main__":
    main()
