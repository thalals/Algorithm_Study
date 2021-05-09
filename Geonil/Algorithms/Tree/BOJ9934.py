# 완전 이진 트리 (BOJ 9934)
import sys
sys.setrecursionlimit(10**6)
In = sys.stdin.readline

k = int(In())
buildings = list(map(str, In().rstrip().split()))
tree = [[] for _ in range(k)]


def infix_to_tree(left: int, right: int, lv: int):
    if left == right:
        tree[lv].append(buildings[left])
        return

    mid = (right+left)//2
    tree[lv].append(buildings[mid])
    infix_to_tree(left, mid-1, lv+1)
    infix_to_tree(mid+1, right, lv+1)


def main():
    infix_to_tree(0, 2**k-2, 0)
    for level in tree:
        print(' '.join(level))


if __name__ == "__main__":
    main()
