import sys
In = sys.stdin.readline


def main():
    num = int(In())
    lst = []
    msg = []
    cnt = 1
    check = True
    top = -1

    for _ in range(num):
        number = int(In())
        while cnt <= number:
            lst.append(cnt)
            cnt += 1
            msg.append('+')

        if lst[top] == number:
            lst.pop()
            msg.append('-')
        else:
            check = False
            break

    if check:
        for oper in msg:
            print(oper)
    else:
        print('No')


main()
