# 문제집
import sys
import heapq

In = sys.stdin.readline


class Workbook():
    def __init__(self, n):
        self.n = n
        self.pointer = 1
        self.easyheap = []
        self.ordered = []
        self.problems = [False]*(n+1)
        self.solved = [False]*(n+1)

    def push(self, con):
        heapq.heappush(self.easyheap, con)
        self.problems[con[1]] = True

    def solve(self):
        while True:
            if len(self.ordered) == self.n:
                break
            print(self.ordered)

            if self.solved[self.pointer]:
                self.pointer += 1
                continue

            if not self.problems[self.pointer] and not self.solved[self.pointer]:
                self.ordered.append(self.pointer)
                self.solved[self.pointer] = True
            else:
                print('---')
                print(self.easyheap)
                solve_pro = heapq.heappop(self.easyheap)
                print(solve_pro)
                print(self.easyheap)
                print('---')

                self.ordered.append(solve_pro[0])
                self.solved[solve_pro[0]]
                if not self.solved[solve_pro[1]] and not self.problems[solve_pro[1]]:
                    self.ordered.append(solve_pro[1])
                    self.solved[solve_pro[1]]

            self.pointer += 1

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
