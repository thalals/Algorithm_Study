# 이중 우선순위 큐
# Index Error : heap 2개 이용, poped 배열로 체크
# Index Error solve : code 수정 (마지막 조건)
import sys
import heapq

In = sys.stdin.readline


class DoulbePQ():
    def __init__(self, n):
        self.maxheap = []
        self.minheap = []
        self.poped = [False] * n
        self.label = 0

    def push(self, n):
        heapq.heappush(self.maxheap, (-n, n, self.label))
        heapq.heappush(self.minheap, (n, self.label))
        self.label += 1

    def pop(self, flag):
        # 1 => max, -1 => min
        if flag == 1:
            while True:
                if self.maxheap:
                    result = heapq.heappop(self.maxheap)
                    if not self.poped[result[2]]:
                        self.poped[result[2]] = True
                        break
                else:
                    break
        else:
            while True:
                if self.minheap:
                    result = heapq.heappop(self.minheap)
                    if not self.poped[result[1]]:
                        self.poped[result[1]] = True
                        break
                else:
                    break

    def last(self):
        if not self.maxheap or not self.minheap:
            print('EMPTY')
            return

        while self.poped[self.maxheap[0][2]]:
            heapq.heappop(self.maxheap)
            if not self.maxheap:
                break

        while self.poped[self.minheap[0][1]]:
            heapq.heappop(self.minheap)
            if not self.minheap:
                break

        if self.maxheap and self.minheap:
            print(self.maxheap[0][1], self.minheap[0][0])
        else:
            print('EMPTY')


def main():
    test_case = int(In())
    for _ in range(test_case):
        n = int(In())
        double_pq = DoulbePQ(n)
        for i in range(n):
            command, flag = map(str, In().rstrip().split())
            flag = int(flag)
            if command == 'D':
                double_pq.pop(flag)
            else:
                double_pq.push(flag)
        double_pq.last()


if __name__ == "__main__":
    main()
