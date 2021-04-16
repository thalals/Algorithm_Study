# 최소 힙
import sys
import heapq
In = sys.stdin.readline


class MinHeap():
    def __init__(self):
        self.heap = []

    def push(self, num):
        heapq.heappush(self.heap, num)

    def pop(self):
        if self.heap:
            return heapq.heappop(self.heap)
        else:
            return 0


def main():
    n = int(In())
    mh = MinHeap()

    for _ in range(n):
        num = int(In())

        if num == 0:
            print(mh.pop())
        else:
            mh.push(num)


if __name__ == "__main__":
    main()
