# 문제집 (BOJ 1766)
# topological sorting + Priority Queue
import sys
import heapq

In = sys.stdin.readline


class Workbook():
    def __init__(self, n: int):
        self.n = n
        self.minheap = []
        self.ordered = []
        self.graph = [[] for _ in range(n+1)]
        self.degree = [0] * (n+1)

    def push(self, item: tuple):
        first, last = item
        self.degree[last] += 1
        self.graph[first].append(last)

    def solve(self):
        # push 0 degree vertex
        for i in range(1, self.n+1):
            if self.degree[i] == 0:
                heapq.heappush(self.minheap, i)

        # topological sorting with minheap
        while self.minheap:
            solved = heapq.heappop(self.minheap)
            self.ordered.append(solved)

            for problem in self.graph[solved]:
                self.degree[problem] -= 1
                if self.degree[problem] == 0:
                    heapq.heappush(self.minheap, problem)

        for problem in self.ordered:
            print(problem, end=' ')


def main():
    n, k = map(int, In().split())
    workbook = Workbook(n)
    for _ in range(k):
        condition = tuple(map(int, In().split()))
        workbook.push(condition)
    workbook.solve()


if __name__ == "__main__":
    main()
