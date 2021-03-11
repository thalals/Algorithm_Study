import sys
import heapq
from collections import defaultdict
In = sys.stdin.readline

INF = float('inf')

num_v, num_e = map(int, In().split())
start_v = int(In())


class Graph:
    def __init__(self, n):
        self.graph = [[INF]*n for _ in range(n)]
        self.num_vertex = n

        for i in range(n):
            for j in range(n):
                if i == j:
                    self.graph[i][j] = 0

    def set_graph(self, num_e):
        for _ in range(num_e):
            i, j, w = map(int, In().split())
            self.graph[i-1][j-1] = min(self.graph[i-1][j-1], w)

    def daijkstra(self, start_vertex):
        self.distance = [float('inf')]*self.num_vertex
        self.distance[start_vertex] = 0

        hq = []
        for idx, dist in enumerate(self.distance):
            heapq.heappush(hq, (dist, idx))

        while hq:
            dist, idx = heapq.heappop(hq)

            if dist < self.distance[idx]:
                continue

            for i in range(self.num_vertex):
                comp_dist = self.distance[idx] + self.graph[idx][i]
                if comp_dist < self.distance[i]:
                    heapq.heappush(hq, (comp_dist, i))
                    self.distance[i] = comp_dist

        for item in self.distance:
            if item == float('inf'):
                print('INF')
            else:
                print(item)


def main():
    graph = Graph(num_v)
    graph.set_graph(num_e)
    graph.daijkstra(start_v-1)


if __name__ == "__main__":
    main()
