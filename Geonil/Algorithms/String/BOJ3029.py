# 경고 (BOJ 3029)
import sys
In = sys.stdin.readline


def time_to_sec(time: list) -> int:
    return time[0]*3600 + time[1]*60 + time[2]


def sec_to_time(sec: int) -> list:
    h = str(sec // 3600)
    sec %= 3600
    m = str(sec // 60)
    sec %= 60
    s = str(sec)

    if len(h) == 1:
        h = '0'+h
    if len(m) == 1:
        m = '0' + m
    if len(s) == 1:
        s = '0' + s

    return [h, m, s]


def main():
    now = list(map(int, In().split(':')))
    throw = list(map(int, In().split(':')))

    now_sec = time_to_sec(now)
    throw_sec = time_to_sec(throw)
    if throw_sec <= now_sec:
        throw_sec += 24*60*60

    print(':'.join(sec_to_time(throw_sec - now_sec)))


if __name__ == "__main__":
    main()
