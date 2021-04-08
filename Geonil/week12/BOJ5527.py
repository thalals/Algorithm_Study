# 전구 장식
import sys
In = sys.stdin.readline


def main():
    n = int(In())
    bulbs = list(map(int, In().split()))
    lst = []
    cnt = 1

    # split sub bulbs
    for i in range(0, n-1):
        if bulbs[i] != bulbs[i+1]:
            cnt += 1
        else:
            lst.append(cnt)
            cnt = 1
    # add last bulbs
    lst.append(cnt)

    answer = 0
    length = len(lst)

    if length == 1:
        answer = lst[0]
    else:
        for i in range(length):
            if i == 0:
                tmp = lst[i] + lst[i+1]
            elif i == length-1:
                tmp = lst[i-1] + lst[i]
            else:
                tmp = lst[i-1] + lst[i] + lst[i+1]
            answer = max(answer, tmp)

    print(answer)


if __name__ == "__main__":
    main()
