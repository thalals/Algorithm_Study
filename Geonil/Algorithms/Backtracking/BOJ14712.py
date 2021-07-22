"""
problem : 넴모넴모 (Easy) (BOJ 14712)
comment : dfs 이용
"""
import sys

sys.setrecursionlimit(10 ** 6)
In = sys.stdin.readline

N, M = map(int, In().split())
nemo = [[False for _ in range(M + 1)] for _ in range(N + 1)]
answer = 0


def check(x, y):
    return nemo[x - 1][y] and nemo[x][y - 1] and nemo[x - 1][y - 1]


def dfs(cnt):
    global answer

    if cnt == N * M:
        answer += 1
        return

    x = cnt // M + 1
    y = cnt % M + 1

    dfs(cnt + 1)

    if not check(x, y):
        nemo[x][y] = True
        dfs(cnt + 1)
        nemo[x][y] = False


def main():
    dfs(0)
    print(answer)


if __name__ == "__main__":
    main()
