import sys
import heapq
In = sys.stdin.readline

a, b = map(int, In().split())
num_n, num_m = map(int, In().split())


class Graph:
    def __init__(self, num_vertex):
        self.graph = [[] for _ in range(num_vertex)]
        self.num_vertex = num_vertex

    def input_edge(self, num_edge):
        for _ in range(num_edge):
            i, j = map(int, In().split())
            self.graph[i-1].append([j-1, 1])
            self.graph[j-1].append([i-1, 1])

    def daijkstra(self, start):
        self.distance = [float('inf')] * self.num_vertex
        self.distance[start] = 0

        hq = []
        heapq.heappush(hq, (0, start))

        while hq:
            cnt, vt = heapq.heappop(hq)

            if cnt < self.distance[vt]:
                continue

            for vertex, count in self.graph[vt]:
                if count + self.distance[vt] < self.distance[vertex]:
                    self.distance[vertex] = count + self.distance[vt]
                    heapq.heappush(hq, (count + self.distance[vt], vertex))

        return self.distance


def main():
    graph = Graph(num_n)
    graph.input_edge(num_m)
    distance = graph.daijkstra(a-1)
    answer = distance[b-1]
    if answer == float('inf'):
        print(-1)
    else:
        print(answer)


if __name__ == "__main__":
    main()
