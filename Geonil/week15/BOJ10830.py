# 행렬 제곱
import sys
In = sys.stdin.readline

n, squares = map(int, In().split())
matrix = []

for _ in range(n):
    sub = list(map(lambda x: x % 1000, list(map(int, In().split()))))
    matrix.append(sub)


def matmul(a, b):
    tmp = [[0]*n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            for k in range(n):
                tmp[i][j] += a[i][k]*b[k][j]
            tmp[i][j] %= 1000

    return tmp


def solution(m, square):
    if square == 1:
        return m

    if square % 2 == 0:
        return solution(matmul(m, m), square//2)
    else:
        return matmul(m, solution(m, square-1))


def main():
    answer = solution(matrix, squares)

    for rows in answer:
        rows = list(map(str, rows))
        print(' '.join(rows))


if __name__ == "__main__":
    main()
