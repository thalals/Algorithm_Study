# 트리의 부모 찾기 (BOJ 11725)
import sys
from collections import deque, defaultdict

In = sys.stdin.readline


def bfs(tree):
    visited = []
    answer = dict()

    queue = deque()
    queue.append(1)
    visited.append(1)

    while queue:
        node = queue.popleft()

        for x in tree[node]:
            if x not in visited:
                answer[x] = node
                visited.append(x)
                queue.append(x)

    return answer


def main():
    n = int(In())
    tree = defaultdict(list)

    for _ in range(n-1):
        n1, n2 = map(int, In().split())
        tree[n1].append(n2)
        tree[n2].append(n1)

    answer = bfs(tree)
    for i in range(2, n+1):
        print(answer[i])


if __name__ == "__main__":
    main()
