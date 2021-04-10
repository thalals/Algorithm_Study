# 내려가기
import sys
In = sys.stdin.readline


def main():
    n = int(In())

    number_table = []
    for _ in range(n):
        # 100,000 * 3 * 4 = 1,200,000 = 1.2 MB
        number_table.append(list(map(int, In().split())))

    # 100,000 * 2 * 4 = 800,000 = 0.8 MB
    maximum = [0]*(n+1)
    mininum = [0]*(n+1)

    for line, numbers in enumerate(number_table):

        for i in range(n, 0, -1):
            if line+1 <= i:
                pass

    pass


if __name__ == "__main__":
    main()
