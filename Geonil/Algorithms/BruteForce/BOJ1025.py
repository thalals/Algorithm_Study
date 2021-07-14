"""
problem : 제곱수 찾기 (BOJ 1025)
comment : 반복문, 제곱수확인
"""
import sys

In = sys.stdin.readline

n, m = map(int, In().split())

ceils = []
for _ in range(n):
    ceils.append(list(In().rstrip()))


def is_square(num):
    sqrt = num ** 0.5
    diff = sqrt - int(sqrt)

    if diff == 0:
        return True
    return False


def main():
    answer = -1

    for i in range(n):
        for j in range(m):
            for k in range(-n, n):
                for l in range(-m, m):
                    if k == 0 and l == 0:
                        continue
                    sequence = ""
                    idx = 0
                    x, y = i, j

                    while True:
                        if not 0 <= x < n or not 0 <= y < m:
                            break

                        sequence += ceils[x][y]
                        idx += 1
                        if is_square(int(sequence)):
                            answer = max(answer, int(sequence))
                        x = i + idx * k
                        y = j + idx * l

    print(answer)


if __name__ == "__main__":
    main()
