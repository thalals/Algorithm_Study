import sys
import heapq
In = sys.stdin.readline

num_v, num_e = map(int, In().split())
start_v = int(In())


class Graph:
    def __init__(self, n):
        self.graph = [[] for _ in range(n)]
        self.num_vertex = n

    def set_graph(self, num_e):
        for _ in range(num_e):
            i, j, w = map(int, In().split())
            self.graph[i-1].append([j-1, w])

    def daijkstra(self, start_vertex):
        self.distance = [float('inf')]*self.num_vertex
        self.distance[start_vertex] = 0

        hq = []
        heapq.heappush(hq, (0, start_vertex))

        while hq:
            dist, idx = heapq.heappop(hq)

            if dist < self.distance[idx]:
                continue

            for v, w in self.graph[idx]:
                comp_dist = self.distance[idx] + w
                if comp_dist < self.distance[v]:
                    heapq.heappush(hq, (comp_dist, v))
                    self.distance[v] = comp_dist

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
