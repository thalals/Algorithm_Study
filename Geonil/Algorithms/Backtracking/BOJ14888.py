"""
problem : 연산자 끼워넣기 (BOJ 14888)
comment : dfs 이용
"""
import sys

sys.setrecursionlimit(10 ** 6)


def intput():
    return sys.stdin.readline().rstrip()


N = int(intput())
numbers = list(map(int, input().split()))
operations = list(map(int, input().split()))

answer = [float("-inf"), float("inf")]


def cal(a, b, mod):
    if mod == 0:
        return a + b
    elif mod == 1:
        return a - b
    elif mod == 2:
        return a * b
    elif mod == 3:
        if a < 0:
            return -(-a // b)
        return a // b


def dfs(idx, result):
    if idx + 1 == N:
        answer[0] = max(answer[0], result)
        answer[1] = min(answer[1], result)
        return

    a, b = result, numbers[idx + 1]

    for i in range(4):
        if operations[i] == 0:
            continue

        operations[i] -= 1
        dfs(idx + 1, cal(a, b, i))
        operations[i] += 1


def main():
    dfs(0, numbers[0])
    print("\n".join(map(str, answer)))


if __name__ == "__main__":
    main()
