# 로봇 청소기
import sys
In = sys.stdin.readline

directions = [
    [-1, 0],
    [0, 1],
    [1, 0],
    [0, -1]
]


def get_left(d):
    return (d-1) % 4


def main():
    n, m = map(int, In().split())
    r, c, d = map(int, In().split())
    maps = []
    for _ in range(n):
        sub = list(map(int, In().split()))
        maps.append(sub)

    cnt = 0
    turn_cnt = 0
    clean = True

    while True:
        if clean:
            maps[r][c] = 2
            cnt += 1

        left_x, left_y = directions[get_left(d)]

        if maps[r+left_x][c+left_y] == 0:
            clean = True
            r += left_x
            c += left_y
            d = get_left(d)
            turn_cnt = 0
        elif turn_cnt < 4:
            clean = False
            d = get_left(d)
            turn_cnt += 1
        else:
            back_x, back_y = directions[(d+2) % 4]
            if maps[r+back_x][c+back_y] == 1:
                break
            else:
                clean = False
                r += back_x
                c += back_y
                turn_cnt = 0

    print(cnt)


if __name__ == "__main__":
    main()
