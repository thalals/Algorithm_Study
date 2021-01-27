import sys
In = sys.stdin.readline


def solving(lst):
    # 산술평균
    mean = round(sum(lst)/len(lst), 0)
    print(int(mean))

    # 중앙값
    print(lst[len(lst)//2])

    # 최빈값
    sub_lst = [0 for _ in range(8001)]
    for item in lst:
        sub_lst[item+4000] += 1

    num = 0  # 최빈값 개수
    idx = 0  # index
    for cnt in sub_lst:
        if max(sub_lst) == cnt:
            num += 1
            mode = idx-4000
            if num == 2:
                break
        idx += 1
    print(mode)

    # 범위
    print(lst[-1]-lst[0])


def main():
    num = int(In())
    lst = []

    for _ in range(num):
        lst.append(int(In()))

    lst.sort()
    solving(lst)


main()
