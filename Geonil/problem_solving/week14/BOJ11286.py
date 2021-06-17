# 절댓값 힙
import sys
import heapq
In = sys.stdin.readline


class AbsHeap():
    def __init__(self):
        self.positive_heap = []
        self.negative_heap = []

    def push(self, num):
        if num < 0:
            heapq.heappush(self.negative_heap, -num)
        else:
            heapq.heappush(self.positive_heap, num)

    def pop(self):
        if not self.negative_heap and not self.positive_heap:
            return 0
        elif not self.negative_heap:
            return heapq.heappop(self.positive_heap)
        elif not self.positive_heap:
            return -heapq.heappop(self.negative_heap)
        else:
            if self.negative_heap[0] <= self.positive_heap[0]:
                return -heapq.heappop(self.negative_heap)
            else:
                return heapq.heappop(self.positive_heap)


def main():
    n = int(In())
    abs_heap = AbsHeap()

    for _ in range(n):
        num = int(In())

        if num == 0:
            print(abs_heap.pop())
        else:
            abs_heap.push(num)


if __name__ == "__main__":
    main()
