import sys
In = sys.stdin.readline

local_cnt = 0
apart = []


def check_deep(idx_i, idx_j):
    global local_cnt
    global apart

    local_cnt += 1
    apart[idx_i][idx_j] = '0'

    if idx_i > 0 and apart[idx_i-1][idx_j] == '1':
        check_deep(idx_i-1, idx_j)

    if idx_i < len(apart)-1 and apart[idx_i+1][idx_j] == '1':
        check_deep(idx_i+1, idx_j)

    if idx_j > 0 and apart[idx_i][idx_j-1] == '1':
        check_deep(idx_i, idx_j-1)

    if idx_j < len(apart)-1 and apart[idx_i][idx_j+1] == '1':
        check_deep(idx_i, idx_j+1)


def main():
    global local_cnt
    global apart

    map_size = int(In())
    apart_cnt = 0
    local_list = []

    for _ in range(map_size):
        apart.append(list(In().rstrip()))

    for i in range(map_size):
        for j in range(map_size):
            if apart[i][j] == '1':
                local_cnt = 0
                apart_cnt += 1

                check_deep(i, j)
                local_list.append(local_cnt)

    local_list.sort()

    print(apart_cnt)
    for l in local_list:
        print(l)


main()
