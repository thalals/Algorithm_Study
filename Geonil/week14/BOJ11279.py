# 최대 힙
import sys
import heapq
In = sys.stdin.readline


class Heap():
    def __init__(self):
        self.heap = []

    def push(self, num):
        heapq.heappush(self.heap, (-num, num))

    def pop(self):
        if self.heap:
            return heapq.heappop(self.heap)[1]
        else:
            return 0


def main():
    n = int(In())
    h = Heap()

    for _ in range(n):
        num = int(In())

        if num == 0:
            print(h.pop())
        else:
            h.push(num)


if __name__ == "__main__":
    main()
