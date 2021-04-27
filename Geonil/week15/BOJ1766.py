# 문제집
import sys
import heapq

In = sys.stdin.readline


class Workbook():
    def __init__(self, n):
        self.n = n
        self.easyheap = []
        self.ordered = []
        self.problems = [0]*(n+1)
        self.solved = [False]*(n+1)

    def push(self, con):
        heapq.heappush(self.easyheap, con)
        self.problems[con[1]] += 1

    def solve(self):
        pointer: int = 1
        print(self.easyheap)
        while self.easyheap:
            print(heapq.heappop(self.easyheap))

        while True:
            if len(self.ordered) == self.n:
                break

            print(self.ordered)

            if pointer <= self.n:
                if self.solved[pointer]:
                    pointer += 1
                    continue

                if self.problems[pointer] == 0:
                    self.solved[pointer] = True
                    self.ordered.append(pointer)
                    pointer += 1
                else:
                    first, last = self.easyheap[0]
                    print(pointer, first, last)
                    break

            # else:
            #     print('---')
            #     print(self.easyheap)
            #     first, after = heapq.heappop(self.easyheap)
            #     print(self.easyheap)
            #     print('---')

            #     if not self.solved[first]:
            #         self.ordered.append(first)
            #         self.solved[first] = True

            #     if not self.solved[after]:
            #         if self.problems[after] == 1:
            #             self.problems[after] -= 1
            #             self.ordered.append(after)
            #             self.solved[after]
            #         else:
            #             self.problems[after] -= 1

        print(self.ordered)


def main():
    n, k = map(int, In().split())
    workbook = Workbook(n)
    for _ in range(k):
        condition = tuple(map(int, In().split()))
        workbook.push(condition)
    workbook.solve()


if __name__ == "__main__":
    main()
