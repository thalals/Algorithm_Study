import sys
In = sys.stdin.readline


def merge(lst, left, mid, right):
    result = []
    i = left
    j = mid+1

    while i <= mid and j <= right:
        if lst[i] <= lst[j]:
            result.append(lst[i])
            i += 1
        else:
            result.append(lst[j])
            j += 1

    # 나머지
    if mid < i:
        for l in range(j, right+1):
            result.append(lst[l])
    else:
        for l in range(i, mid+1):
            result.append(lst[l])

    # return to lst
    for l, item in zip(range(left, right+1), result):
        lst[l] = item


def merge_sort(lst, left, right):
    if left < right:
        mid = (left+right)//2
        merge_sort(lst, left, mid)
        merge_sort(lst, mid+1, right)
        merge(lst, left, mid, right)


def main():
    num = int(In())
    lst = []
    for _ in range(num):
        lst.append(int(In()))

    merge_sort(lst, 0, num-1)

    for item in lst:
        print(item)


main()
