import sys
In = sys.stdin.readline

N, K = map(int, In().split())


def deep(n, k):
    if n >= k:
        return n-k
    elif k == 1:
        return 1
    elif k % 2 == 1:
        return min(deep(n, k-1), deep(n, k+1)) + 1
    else:
        return min(k-n, deep(n, k//2))


def main():
    result = deep(N, K)
    print(result)


if __name__ == "__main__":
    main()
