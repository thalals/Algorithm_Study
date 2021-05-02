# 듣보잡 (BOJ 1764)
import sys
In = sys.stdin.readline

n, m = map(int, In().split())
heard = [In().rstrip() for _ in range(n)]


def binary_search(person: str, start: int, end: int) -> bool:
    mid: int = (start + end)//2
    if start > end:
        return False

    if heard[mid] == person:
        return True
    elif heard[mid] < person:
        return binary_search(person, mid+1, end)
    else:
        return binary_search(person, start, mid-1)


def main():
    lst = []
    heard.sort()

    for _ in range(m):
        person = In().rstrip()
        if binary_search(person, 0, n-1):
            lst.append(person)

    lst.sort()
    print(len(lst))
    print('\n'.join(lst))


if __name__ == "__main__":
    main()
