# 트리 (BOJ 1068)
import sys
from collections import deque, defaultdict

In = sys.stdin.readline
n = int(In())
lst = list(map(int, In().split()))
del_node = int(In())
tree = defaultdict(list)


def bfs(root):
    queue = deque()
    queue.append(root)
    cnt = 0

    if del_node == root:
        return cnt

    while queue:
        node = queue.popleft()

        if not tree[node]:
            cnt += 1

        for v in tree[node]:
            if v == del_node:
                if len(tree[node]) == 1:
                    cnt += 1
                continue
            queue.append(v)

    return cnt


def main():
    for node, parent in enumerate(lst):
        if parent == -1:
            root = node
            continue
        tree[parent].append(node)

    answer = bfs(root)
    print(answer)


if __name__ == '__main__':
    main()
