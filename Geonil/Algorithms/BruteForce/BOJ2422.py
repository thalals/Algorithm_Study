"""
problem : 한윤정이 이탈리아에 가서 아이스크림을 사먹는데 (BOJ 2422)
comment : 
"""
import sys
from itertools import combinations


In = sys.stdin.readline
checking = [[0 for _ in range(200)] for _ in range(200)]


def main():
    n, m = map(int, In().split())
    answer = 0

    for _ in range(m):
        i, j = map(int, In().split())
        checking[i - 1][j - 1] = 1
        checking[j - 1][i - 1] = 1

    for i in range(n - 2):
        for j in range(i + 1, n - 1):
            for k in range(j + 1, n):
                if checking[i][j] or checking[j][k] or checking[i][k]:
                    continue
                answer += 1

    print(answer)


if __name__ == "__main__":
    main()
