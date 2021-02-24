import sys
In = sys.stdin.readline


def main():
    n = int(In())
    line = list(map(int, In().split()))
    line.sort()
    result = 0
    for minute in line:
        result += minute * n
        n -= 1
    print(result)


if __name__ == "__main__":
    main()
