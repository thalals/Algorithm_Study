"""
problem : 계란으로 계란치기 (BOJ 16987)
comment : pypy3, dfs이용
"""
import sys

sys.setrecursionlimit(10 ** 5)


def intput():
    return sys.stdin.readline().rstrip()


N = int(input())
eggs = []
for _ in range(N):
    durability, weight = map(int, input().split())
    eggs.append([durability, weight])
answer = 0


def get_break():
    cnt = 0
    for egg in eggs:
        if egg[0] <= 0:
            cnt += 1
    return cnt


def dfs(pos):
    global answer
    flag = False

    if pos == N:
        answer = max(answer, get_break())
        return
    if eggs[pos][0] <= 0:
        dfs(pos + 1)
        return

    for i in range(N):
        if i == pos or eggs[i][0] <= 0:
            continue
        flag = True
        eggs[i][0] -= eggs[pos][1]
        eggs[pos][0] -= eggs[i][1]
        dfs(pos + 1)
        eggs[i][0] += eggs[pos][1]
        eggs[pos][0] += eggs[i][1]
    if not flag:
        dfs(pos + 1)


def main():
    dfs(0)
    print(answer)


if __name__ == "__main__":
    main()
