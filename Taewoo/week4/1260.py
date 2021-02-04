from collections import deque
import sys

N, M, V = map(int, sys.stdin.readline().rstrip().split())

graph = [[] for _ in range(N + 1)]
visited = [False for _ in range(N + 1)]

def dfs(x, order):
    visited[x] = True
    order.append(x)
    for next in graph[x]:
        if not(visited[next]):
            dfs(next, order)

def bfs(start, order):
    q = deque()
    visited[start] = True
    q.append(start)

    while(len(q)):
        node = q.popleft()
        order.append(node)
        for next in graph[node]:
            if visited[next]:
                continue
            visited[next] = True
            q.append(next)

for _ in range(M):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    graph[x].append(y)
    graph[y].append(x)

for i in range(N + 1):
    graph[i].sort()

dfsOrder = []
bfsOrder = []
dfs(V, dfsOrder)
visited = [False for _ in range(N + 1)]
bfs(V, bfsOrder)

print(dfsOrder)
print(bfsOrder)