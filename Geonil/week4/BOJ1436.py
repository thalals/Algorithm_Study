import sys
In = sys.stdin.readline


def checking_triple(string):
    last_idx = len(string)-3
    for i in range(last_idx+1):
        if string[i:i+3] == '666':
            return True
    return False


def last_666(string):
    f = string[:-3]
    l = string[-3:]
    if '6' in f:
        return False
    elif l == '666':
        return True


def main():
    num = int(In())
    answer = 666

    while True:
        if checking_triple(str(answer)):
            num -= 1
        if num == 0:
            break

        answer += 1

    print(answer)


main()
