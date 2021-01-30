import sys
In = sys.stdin.readline


def main():
    num = int(In())

    end_num = '666'
    cnt = 1
    length = 0

    while True:
        if num - cnt <= 0:
            break

        num -= cnt

        cnt = 0
        length += 1

        for l in range(length+1):
            if l < length:
                cnt = cnt*9 + pow(10, l)
            else:
                cnt = cnt*8 + pow(10, l)

    radix = length + 3
    print('radix : ', radix)
    print('count : ', cnt)
    print('num : ', num)

    front = str(pow(10, length))


main()
