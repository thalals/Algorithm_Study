# 파일 정리 (BOJ 20291)
import sys
from collections import defaultdict
In = sys.stdin.readline


def main():
    n = int(In())
    keys = set()
    ext_dict = defaultdict(int)

    for _ in range(n):
        file_name, extension = In().rstrip().split('.')
        keys.add(extension)
        ext_dict[extension] += 1

    keys = list(keys)
    keys.sort()

    for key in keys:
        print(f'{key} {ext_dict[key]}')


if __name__ == "__main__":
    main()
