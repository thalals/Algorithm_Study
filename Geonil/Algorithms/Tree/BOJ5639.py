# 이진 검색 트리 (BOJ 5639)
import sys
sys.setrecursionlimit(10**9)
In = sys.stdin.readline

prefix = []
postfix = []


def postorder(start, finish):
    if start > finish:
        return

    idx = finish+1
    for i in range(start+1, finish+1):
        if prefix[start] < prefix[i]:
            idx = i
            break

    postorder(start+1, idx-1)
    postorder(idx, finish)
    postfix.append(prefix[start])


def main():
    while True:
        try:
            prefix.append(int(In()))
        except ValueError or EOFError:
            break

    postorder(0, len(prefix)-1)
    print('\n'.join(map(str, postfix)))


if __name__ == "__main__":
    main()
