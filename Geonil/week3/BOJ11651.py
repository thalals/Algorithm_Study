import sys
In = sys.stdin.readline


def merge(lst, left, mid, right):
    result = []
    i = left
    j = mid+1

    while i <= mid and j <= right:
        if lst[i][1] < lst[j][1]:
            result.append(lst[i])
            i += 1
        elif lst[i][1] == lst[j][1]:
            if lst[i][0] < lst[j][0]:
                result.append(lst[i])
                i += 1
            else:
                result.append(lst[j])
                j += 1
        else:
            result.append(lst[j])
            j += 1

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
        lst.append(list(map(int, In().split())))

    merge_sort(lst, 0, num-1)

    for point in lst:
        print(point[0], point[1])


main()
