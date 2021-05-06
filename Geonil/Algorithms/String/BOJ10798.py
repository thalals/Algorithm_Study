# 세로 읽기 (BOJ 10798)
import sys
In = sys.stdin.readline


def main():
    words = []
    sizes = []
    ordered = ''
    for _ in range(5):
        sub = In().rstrip()
        sizes.append(len(sub))
        words.append(sub)

    size = max(sizes)

    for i in range(size):
        for j in range(5):
            if i < sizes[j]:
                ordered += words[j][i]

    print(ordered)


if __name__ == "__main__":
    main()
