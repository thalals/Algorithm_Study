# !밀비 급일 (BOJ 11365)
import sys
In = sys.stdin.readline


def main():
    while True:
        string = In().rstrip()
        if string == 'END':
            break
        for c in range(len(string)-1, -1, -1):
            print(string[c], end='')
        print()


if __name__ == "__main__":
    main()
