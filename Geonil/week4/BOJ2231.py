import sys
In = sys.stdin.readline


def creater(num):
    # 자리수 구하기
    answer = 0
    length = len(str(num))
    start_num = max(0, num - 9*length)

    for i in range(start_num, num):
        n = i
        for radix in str(i):
            n += int(radix)

        if n == num:
            answer = i
            break

    return answer


def main():
    num = int(In())
    print(creater(num))


main()
