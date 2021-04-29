import sys
In = sys.stdin.readline


def main():
    num = In()
    lst = [0 for _ in range(10)]

    for n in range(len(num)-1):
        lst[int(num[n])] += 1

    answer = ''

    for item in range(9, -1, -1):
        answer = answer + str(item)*lst[item]

    print(answer)


main()
