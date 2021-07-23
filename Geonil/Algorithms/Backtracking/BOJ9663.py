"""
problem : N-Queen (BOJ 9663)
comment : 시간초과
"""
import sys


def intput():
    return sys.stdin.readline().rstrip()


row = [-1 for _ in range(14)]

N = int(input())
answer = 0


def check_possible(r):
    for i in range(r):
        if row[i] == row[r] or (r - i) == abs(row[i] - row[r]):
            return False
    return True


def dfs(cnt):
    global answer
    if cnt == N:
        answer += 1
        return

    for i in range(N):
        row[cnt] = i
        if check_possible(cnt):
            dfs(cnt + 1)


def main():
    dfs(0)
    print(answer)


if __name__ == "__main__":
    main()
