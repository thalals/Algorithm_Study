# 부분 문자열 (BOJ16916)
# 시간 초과
import sys
In = sys.stdin.readline


def get_pi(string: str) -> list:
    length = len(string)
    pi = [0] * length
    idx = 0

    for i in range(1, length):
        while idx > 0 and string[i] != string[idx]:
            idx = pi[idx-1]

        if string[i] == string[idx]:
            idx += 1
            pi[i] = idx

    return pi


def kmp(string: str, sub: str) -> bool:
    pi = get_pi(sub)
    len_main = len(string)
    len_sub = len(sub)
    idx = 0

    for i in range(len_main):
        while idx > 0 and string[i] != sub[idx]:
            idx = pi[idx-1]

        if string[i] == sub[idx]:
            if idx == len_sub-1:
                return True
            else:
                idx += 1

    return False


def main():
    string = In().rstrip()
    sub = In().rstrip()
    if kmp(string, sub):
        print(1)
    else:
        print(0)


if __name__ == "__main__":
    main()
