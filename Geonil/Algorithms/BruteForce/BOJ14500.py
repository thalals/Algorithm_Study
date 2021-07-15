"""
problem : 테트로미노 (BOJ 14500)
comment : 블럭 초기화
"""
import sys

In = sys.stdin.readline

blocks = [
    [(0, 1), (1, 0), (1, 1)],
    [(0, 1), (0, 2), (0, 3)],
    [(1, 0), (2, 0), (3, 0)],
    [(1, 0), (0, 1), (0, 2)],
    [(0, 1), (0, 2), (-1, 2)],
    [(1, 0), (1, 1), (1, 2)],
    [(0, 1), (0, 2), (1, 2)],
    [(1, 0), (2, 0), (2, 1)],
    [(0, 1), (1, 1), (2, 1)],
    [(0, 1), (1, 0), (2, 0)],
    [(1, 0), (2, 0), (2, -1)],
    [(1, 0), (1, 1), (2, 1)],
    [(1, 0), (1, -1), (2, -1)],
    [(0, 1), (-1, 1), (-1, 2)],
    [(0, 1), (1, 1), (1, 2)],
    [(0, 1), (0, 2), (1, 1)],
    [(0, 1), (0, 2), (-1, 1)],
    [(0, 1), (-1, 1), (1, 1)],
    [(-1, 0), (0, 1), (1, 0)],
]

n, m = map(int, In().split())
paper = []
for _ in range(n):
    paper.append(list(map(int, In().split())))


def check(x, y):
    if 0 <= x < n and 0 <= y < m:
        return True
    return False


def main():
    answer = 0

    for i in range(n):
        for j in range(m):
            now = paper[i][j]
            for b in blocks:
                comp = now
                for dx, dy in b:
                    if not check(i + dx, j + dy):
                        break
                    comp += paper[i + dx][j + dy]
                else:
                    answer = max(answer, comp)

    print(answer)


if __name__ == "__main__":
    main()
