import sys
In = sys.stdin.readline


def main():
    num = int(In())
    # lst 초기화
    lst = [0 for _ in range(10000)]

    for _ in range(num):
        lst[int(In())-1] += 1

    k = 1
    for item in lst:
        if item != 0:
            for _ in range(item):
                print(k)
        k += 1


main()
