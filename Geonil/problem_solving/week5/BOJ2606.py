import sys
from collections import defaultdict, deque
In = sys.stdin.readline


def virus_cnt(graph, v_start):
    check_com = []

    queue = deque()
    queue.append(v_start)
    check_com.append(v_start)

    while True:
        if len(queue) == 0:
            break
        v_next = queue.popleft()

        for v in graph[v_next]:
            if v in check_com:
                continue

            check_com.append(v)
            queue.append(v)

    return len(check_com)-1


def main():
    com_num = int(In())
    edge_num = int(In())

    graph = defaultdict(list)

    for _ in range(edge_num):
        v1, v2 = map(int, In().split())
        graph[v1].append(v2)
        graph[v2].append(v1)

    print(virus_cnt(graph, 1))


main()
