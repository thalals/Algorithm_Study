import sys
In = sys.stdin.readline


def xor(x, y):
    return (not (x or y)) or (x and y)


def checking(chess, n_idx, m_idx):
    cnt_1 = 0
    for i in range(8):
        for j in range(8):
            if xor((i+1) % 2 == 0, (j+1) % 2 == 0):
                if chess[i+n_idx][j+m_idx] != 'W':
                    cnt_1 += 1
            else:
                if chess[i+n_idx][j+m_idx] != 'B':
                    cnt_1 += 1

    cnt_2 = 0
    for i in range(8):
        for j in range(8):
            if xor((i+1) % 2 == 0, (j+1) % 2 == 0):
                if chess[i+n_idx][j+m_idx] != 'B':
                    cnt_2 += 1
            else:
                if chess[i+n_idx][j+m_idx] != 'W':
                    cnt_2 += 1

    return min(cnt_1, cnt_2)


def main():
    n, m = map(int, In().split())
    chess = []
    for _ in range(n):
        chess.append(In().rstrip())

    remain_n = n - 8
    reamin_m = m - 8

    answer = 64
    for i in range(remain_n+1):
        for j in range(reamin_m+1):
            answer = min(answer, checking(chess, i, j))

    print(answer)


main()
