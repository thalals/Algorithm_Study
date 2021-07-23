"""
problem : N-Queen (BOJ 9663)
comment : row, left diagonal, right diagnoal
"""
import sys


def intput():
    return sys.stdin.readline().rstrip()


N = int(input())
row, l_dia, r_dia = [False] * N, [False] * (2 * N - 1), [False] * (2 * N - 1)
answer = 0


def dfs(cnt):
    global answer
    if cnt == N:
        answer += 1
        return

    for i in range(N):
        if not (row[i] or l_dia[i + cnt] or r_dia[i - cnt + N - 1]):
            row[i] = l_dia[i + cnt] = r_dia[i - cnt + N - 1] = True
            dfs(cnt + 1)
            row[i] = l_dia[i + cnt] = r_dia[i - cnt + N - 1] = False


def main():
    dfs(0)
    print(answer)


if __name__ == "__main__":
    main()
