import sys
#from collections import defaultdict
In = sys.stdin.readline
size = 19

# 대각 : +1 +1 or +1 -1
# 가로 : 0 +1
# 새로 : +1 0
flag = [[1, 1], [1, -1], [0, 1], [1, 0]]


def check_win(locations):

    for location in locations:
        x, y = location

        for dx, dy in flag:
            cnt = 1
            next_x = x + dx
            next_y = y + dy
            while True:
                if [next_x, next_y] in locations:
                    cnt += 1
                    next_x = next_x + dx
                    next_y = next_y + dy
                else:
                    break
        print(cnt)


def main():
    black_map = []
    white_map = []

    for i in range(1, size+1):
        sub_map = list(map(int, In().split()))
        for j in range(len(sub_map)):
            if sub_map[j] == 1:
                black_map.append([i, j+1])
            elif sub_map[j] == 2:
                white_map.append([i, j+1])
    black_map.sort(key=lambda x: x[1])
    white_map.sort(key=lambda x: x[1])

    check_win(black_map)


if __name__ == "__main__":
    main()
