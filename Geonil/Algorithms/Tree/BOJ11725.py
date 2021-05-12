# 트리의 부모 찾기 (BOJ 11725)
import sys
from collections import deque, defaultdict

In = sys.stdin.readline
n = int(In())
tree = defaultdict(list)


def bfs(tree):
    visited = [False] * (n+1)
    answer = dict()

    queue = deque()
    queue.append(1)
    visited[1] = True

    while queue:
        node = queue.popleft()

        for x in tree[node]:
            if not visited[x]:
                answer[x] = node
                visited[x] = True
                queue.append(x)

    return answer


def main():

    for _ in range(n-1):
        n1, n2 = map(int, In().split())
        tree[n1].append(n2)
        tree[n2].append(n1)

    answer = bfs(tree)
    for i in range(2, n+1):
        print(answer[i])


if __name__ == "__main__":
    main()
