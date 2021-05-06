# 염색체 (BOJ 9342)
import sys
In = sys.stdin.readline

start = ('A', 'B', 'C', 'D', 'E', 'F')
mid = ('A', 'F', 'C')


def check_infected(chrom: str) -> bool:
    length = len(chrom)
    idx = 0

    if chrom[idx] not in start:
        return False

    if not chrom[idx] == 'A':
        idx += 1

    for i in range(3):
        if not chrom[idx] == mid[i]:
            return False

        while True:
            if chrom[idx] == mid[i]:
                idx += 1
                if idx == length:
                    return True
            else:
                break

    if chrom[idx] not in start or idx < length-1:
        return False

    return True


def main():
    n = int(In())

    for _ in range(n):
        chromosome = In().rstrip()
        if check_infected(chromosome):
            print('Infected!')
        else:
            print('Good')


if __name__ == "__main__":
    main()
