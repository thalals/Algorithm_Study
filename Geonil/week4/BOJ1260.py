import sys
from collections import defaultdict, deque

In = sys.stdin.readline
visited_dfs = []
visited_bfs = []


def bfs(graph, v_start):
    visited_bfs.append(v_start)
    queue = deque()
    queue.append(v_start)

    while True:
        if len(queue) == 0:
            break
        pop_v = queue.popleft()
        for v in graph[pop_v]:
            if v in visited_bfs:
                continue
            visited_bfs.append(v)
            queue.append(v)


def dfs(graph, v_start):
    visited_dfs.append(v_start)

    for vertex in graph[v_start]:
        if vertex not in visited_dfs:
            dfs(graph, vertex)


def main():
    v_num, e_num, v_start = map(int, In().split())
    graph = defaultdict(list)
    for _ in range(e_num):
        v1, v2 = map(int, In().split())
        graph[v1].append(v2)
        graph[v2].append(v1)

    for key in graph:
        graph[key].sort()

    dfs(graph, v_start)
    bfs(graph, v_start)

    for v in visited_dfs:
        print(v, end=' ')
    print()
    for v in visited_bfs:
        print(v, end=' ')


main()
