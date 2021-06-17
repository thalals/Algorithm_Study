import sys
In = sys.stdin.readline

# 168ms


def ascending(lst):
    # bubble sort
    for i in range(len(lst)-1, 0, -1):
        for j in range(i):
            if lst[j] > lst[j+1]:
                tmp = lst[j+1]
                lst[j+1] = lst[j]
                lst[j] = tmp


def main():
    num = int(In())
    lst = []
    for _ in range(num):
        lst.append(int(In()))

    ascending(lst)

    for item in lst:
        print(item)


main()
