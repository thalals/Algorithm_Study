# 부분 문자열 (BOJ16916)
# 시간 초과
import sys
In = sys.stdin.readline


def main():
    string = In().rstrip()
    sub = In().rstrip()
    length = len(sub)
    flag = False

    for i in range(len(string)-length+1):
        if not sub[0] == string[i]:
            continue

        if string[i:i+length] == sub:
            flag = True
            break

    if flag:
        print(1)
    else:
        print(0)


if __name__ == "__main__":
    main()
