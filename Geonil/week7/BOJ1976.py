import sys
from collections import defaultdict, deque

In = sys.stdin.readline
connection = []
city = defaultdict(list)


def bfs(start, target):
    visited = []
    queue = deque()
    queue.append(start)

    while queue:
        now = queue.popleft()

        if now == target:
            return True

        for c in city[now]:
            if c not in visited:
                visited.append(c)
                queue.append(c)

    return False


def check_possible(path):
    for i in range(len(path)-1):
        start, target = path[i], path[i+1]
        if [start, target] in connection:
            continue
        else:
            check = bfs(start, target)
            if check:
                connection.append([start, target])
                connection.append([target, start])
            else:
                return False

    return True


def main():
    n = int(In())
    m = int(In())

    for i in range(1, n+1):
        sub_lst = list(map(int, In().split()))
        for j in range(n):
            if sub_lst[j] == 1:
                city[i].append(j+1)

    path = list(map(int, In().split()))

    if check_possible(path):
        print('YES')
    else:
        print('NO')


if __name__ == "__main__":
    main()
